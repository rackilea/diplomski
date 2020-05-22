Comparator<CustomInterfaceImplemenationObject> comparator =
    new Comparator<>() {
        @Override
        public int compare(CustomInterfaceImplemenationObject o1,
                           CustomInterfaceImplemenationObject o2) {
            // implement as necessary, compare o1 and o2
        }
    };

Map<CustomInterfaceObject, Double> treeMap =
        new TreeMap<CustomInterfaceObject,Double>(comparator);
treeMap.putAll(hashMap);