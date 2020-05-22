List<String> definedOrder = // define your custom order
    Arrays.asList("animal", "man", "reptile", "bird");

Comparator<String> comparator = new Comparator<String>(){

    @Override
    public int compare(final String o1, final String o2){
        // let your comparator look up your car's color in the custom order
        return Integer.valueOf(definedOrder.indexOf(o1))
            .compareTo(Integer.valueOf(definedOrder.indexOf(o2)));
    }
};

Collections.sort(myList, comparator);