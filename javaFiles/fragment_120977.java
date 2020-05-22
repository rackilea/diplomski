@Override
        protected void populateItem(ListItem rowItem) {
            List<? extends Element> columnMap = rowItem.getModelObject();
            ListView column = new ListView("column", columnMap) {

                @Override
                protected void populateItem(ListItem columnItem) {
                    Element element = columnItem.getModelObject();
                }
            };
            rowItem.add(column);
        }
    };