List<Department> departmentList = getAllDepartments();
            // create root node with its children expanded
            DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode();
            IceUserObject rootObject = new IceUserObject(rootTreeNode);
            rootObject.setText("Root");
            rootObject.setExpanded(true); 
            rootTreeNode.setUserObject(rootObject);

            HashMap<Department, DefaultMutableTreeNode> createdNodesMap = new HashMap<Department, DefaultMutableTreeNode>(
                    0);

            for (Department department : departmentList) {

                DefaultMutableTreeNode currentNode = null;

                if (createdNodesMap.get(department) == null) {
                    log.debug("############ CREATING NODE "
                            + department.getName());
                    currentNode = new DefaultMutableTreeNode();
                    IceUserObject currentObject = new IceUserObject(currentNode);
                    currentObject.setText(department.getName());
                    currentObject.setExpanded(true);
                    currentNode.setUserObject(currentObject);

                    if (department.getParentDepartment() == null) {
                        rootTreeNode.add(currentNode);
                        log.debug("######### NODE " + department.getName()
                                + " ADDED UNDER ROOT");
                    }

                    createdNodesMap.put(department, currentNode);
                } else {
                    log.debug("############ GETTING CREATED NODE "
                            + department.getName());
                    currentNode = createdNodesMap.get(department);
                }

                if (department.getChildren().size() > 0)
                    log.debug("############ NODE " + department.getName()
                            + " HAVE " + department.getChildren().size()
                            + " CHILDREN");
                else
                    log.debug("############ NODE " + department.getName()
                            + " DOES NOT HAVE CHILDREN");

                for (Department department2 : department.getChildren()) {

                    log.debug("############ CREATING CHILD "
                            + department2.getName() + " FOR PARENT "
                            + department.getName());
                    DefaultMutableTreeNode branchNode;
                    if (createdNodesMap.get(department2) == null) {
                        branchNode = new DefaultMutableTreeNode();
                        IceUserObject branchObject = new IceUserObject(
                                branchNode);
                        branchObject.setText(department2.getName());
                        branchObject.setExpanded(true);
                        branchNode.setUserObject(branchObject);
                    } else
                        branchNode = createdNodesMap.get(department2);

                    createdNodesMap.put(department2, branchNode);
                    currentNode.add(branchNode);
                }

            }

            model = new DefaultTreeModel(rootTreeNode);