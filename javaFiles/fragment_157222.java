int inputArray[];
    inputArray = new int[20];
    Random rd = new Random();
    HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < inputArray.length; i++) {
        inputArray[i] = rd.nextInt(10);
    }
    for (int i : inputArray) {
        if (elementCountMap.containsKey(i)) {
            elementCountMap.put(i, elementCountMap.get(i) + 1);
        } else {
            elementCountMap.put(i, 1);
        }
    }
    System.out.println();
    System.out.println("Input Array : " + Arrays.toString(inputArray));
    System.out.println("Element Count : " + elementCountMap);