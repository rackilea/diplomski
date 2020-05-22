filteredItems.predicateProperty().bind(
            Bindings.createObjectBinding(()
                    -> li -> {
                        for (int i=0; i<li.size(); i++) {
                            if (! li.get(i).contains(filterFieldList.get(i).getText())) {
                                return false ;
                            }
                        }
                        return true ;
                    }, 
                    filterFieldList.stream().map(TextField::textProperty)
                         .toArray(StringProperty[]::new)));