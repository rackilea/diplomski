Map<String, Object> eMap = new HashMap<>();
        Set<String> numberList = new HashSet<>();
        numberList.add("Number 1");
        numberList.add("Number 2");
        numberList.add("Number 3");
        eMap.put("Number LIST", numberList);


        Set<String> fruitList = new HashSet<>();
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Tomato");
        eMap.put("Fruit LIST", fruitList);

        String searchedValue="Number 3";

        System.out.println("Is Value exists :"+checkValueExists(eMap,searchedValue));