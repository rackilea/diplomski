Collections.sort(model, new Comparator<InternalCarBoard>(){
            public int compare(InternalCarBoard obj1, InternalCarBoard obj2) {
                // ## Ascending order
                return obj1.getCompanyName().compareToIgnoreCase(obj2.getCompanyName); // To compare string values
                // return Integer.valueOf(obj1.getId()).compareTo(obj2.getId()); // To compare integer values

                // ## Descending order
                // return obj2.getCompanyName().compareToIgnoreCase(obj1.getCompanyName()); // To compare string values
                // return Integer.valueOf(obj2.getId()).compareTo(obj1.getId()); // To compare integer values
            }
        });