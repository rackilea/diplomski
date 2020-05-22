@SuppressWarnings("unchecked") Class<ArrayList<String>> type = (Class)ArrayList.class;

Map<Integer, List<String>> namesPerNumber = 
    MapUtils.lazyMap(
        new HashMap<Integer, List<String>>(), 
        FactoryUtils.instantiateFactory(type));