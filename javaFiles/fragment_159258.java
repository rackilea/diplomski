String[][] newData = new String[dataList.size()][];
    for (int i=0; i<dataList.size(); i++) {
        List<String> subList = dataList.get(i);
        newData[i] = subList.toArray(new String[subList.size()]);
    }

    //newData is a 2x1 array
    for (int i=0; i<newData.length; i++) {
        System.out.println(Arrays.toString(newData[i]));
    }
    //[foo]
    //[bar]