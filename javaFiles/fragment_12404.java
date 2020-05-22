private class UserAttributesMapper implements AttributesMapper {
    @Override
    public Object mapFromAttributes(Attributes attributes) throws NamingException {
        LdapUser user = new LdapUser();
        user.setCn((String)attributes.get("cn").get());
        List<String> memberOf = new ArrayList<String>();

        for(Enumeration vals = attributes.get("memberOf").getAll(); vals.hasMoreElements();){
            memberOf.add((String)vals.nextElement());
        }
        user.setMemberOf(memberOf);
        user.setsAMAccountName((String)attributes.get("sAMAccountName").get());
        user.setMail((String)attributes.get("mail").get());
        return user;
    }
}