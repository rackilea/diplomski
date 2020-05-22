IndexedContainer ic = new IndexedContainer() {
            @Override
            public Collection<?> getSortableContainerPropertyIds() {
                // Default implementation allows sorting only if the property
                // type can be cast to Comparable
                return getContainerPropertyIds();
            }
        };

        ic.setItemSorter(new DefaultItemSorter(new Comparator<Object>() {
                public int compare(Object o1, Object o2) {                

            }
        }));