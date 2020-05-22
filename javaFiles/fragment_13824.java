final Tree tree = new Tree();
//get the top level collection of entities
        Collection<MyEntity> myEntitiesCategories = findEntities(MyEntity.class);//findEntities is one of your method that retrieves entities from a datasource
        for (MyEntity myEntity : myEntitiesCategories) {
            tree.addItem(myEntity);
        }
        tree.addListener(new Tree.ExpandListener() {

            @Override
            public void nodeExpand(ExpandEvent event) {
                MyEntity myEntityCategory = (MyEntity) event.getItemId();
                Collection<MyEntity> myEntities = myEntityCategory.getChildrenMyEntities();
                for (MyEntity myEntity : myEntities) {
                    tree.addItem(myEntity);
                    tree.setParent(myEntity, myEntityCategory);
                    tree.setChildrenAllowed(myEntity, false);//the boolean value could also be true, it depends on whether it can have children or not
                }
            }
        });