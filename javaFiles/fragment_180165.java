public void createGroupUser(SlingHttpServletRequest request) {
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String groupName = request.getParameter("groupName");

    Session session = null;
    ResourceResolver resourceResolver = null;
    try {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put(ResourceResolverFactory.SUBSERVICE, "datawrite");
        resourceResolver = resourceResolverFactory.getServiceResourceResolver(param);
        session = resourceResolver.adaptTo(Session.class);

        // Create UserManager Object
        final UserManager userManager = AccessControlUtil.getUserManager(session);

        // Create a Group
        Group group = null;
        if (userManager.getAuthorizable(groupName) == null) {
            group = userManager.createGroup(groupName);

            ValueFactory valueFactory = session.getValueFactory();
            Value groupNameValue = valueFactory.createValue(groupName, PropertyType.STRING);
            group.setProperty("./profile/givenName", groupNameValue);
            session.save();

            log.info("---> {} Group successfully created.", group.getID());
        } else {
            log.info("---> Group already exist..");
        }

        // Create a User
        User user = null;
        if (userManager.getAuthorizable(userName) == null) {
            user = userManager.createUser(userName, password);

            ValueFactory valueFactory = session.getValueFactory();
            Value firstNameValue = valueFactory.createValue("Arpit", PropertyType.STRING);
            user.setProperty("./profile/givenName", firstNameValue);

            Value lastNameValue = valueFactory.createValue("Bora", PropertyType.STRING);
            user.setProperty("./profile/familyName", lastNameValue);

            Value emailValue = valueFactory.createValue("arpit.p.bora@gmail.com", PropertyType.STRING);
            user.setProperty("./profile/email", emailValue);
            session.save();

            // Add User to Group
            Group addUserToGroup = (Group) (userManager.getAuthorizable(groupName));
            addUserToGroup.addMember(userManager.getAuthorizable(userName));
            session.save();

            // set Resource-based ACLs
            String nodePath = user.getPath();
            setAclPrivileges(nodePath, session);

            log.info("---> {} User successfully created and added into group.", user.getID());
        } else {
            log.info("---> User already exist..");
        }

    } catch (Exception e) {
        log.info("---> Not able to perform User Management..");
        log.info("---> Exception.." + e.getMessage());
    } finally {
        if (session != null && session.isLive()) {
            session.logout();
        }
        if (resourceResolver != null)
            resourceResolver.close();
    }
}

public static void setAclPrivileges(String path, Session session) {
    try {
        AccessControlManager aMgr = session.getAccessControlManager();

        // create a privilege set
        Privilege[] privileges = new Privilege[] { 
                aMgr.privilegeFromName(Privilege.JCR_VERSION_MANAGEMENT),
                aMgr.privilegeFromName(Privilege.JCR_MODIFY_PROPERTIES),
                aMgr.privilegeFromName(Privilege.JCR_ADD_CHILD_NODES),
                aMgr.privilegeFromName(Privilege.JCR_LOCK_MANAGEMENT),
                aMgr.privilegeFromName(Privilege.JCR_NODE_TYPE_MANAGEMENT),
                aMgr.privilegeFromName(Replicator.REPLICATE_PRIVILEGE) };

        AccessControlList acl;
        try {
            // get first applicable policy (for nodes w/o a policy)
            acl = (AccessControlList) aMgr.getApplicablePolicies(path).nextAccessControlPolicy();
        } catch (NoSuchElementException e) {
            // else node already has a policy, get that one
            acl = (AccessControlList) aMgr.getPolicies(path)[0];
        }
        // remove all existing entries
        for (AccessControlEntry e : acl.getAccessControlEntries()) {
            acl.removeAccessControlEntry(e);
        }
        // add a new one for the special "everyone" principal
        acl.addAccessControlEntry(EveryonePrincipal.getInstance(), privileges);

        // the policy must be re-set
        aMgr.setPolicy(path, acl);

        // and the session must be saved for the changes to be applied
        session.save();
    } catch (Exception e) {
        log.info("---> Not able to perform ACL Privileges..");
        log.info("---> Exception.." + e.getMessage());
    }
}