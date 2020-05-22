...
    List<int[]> resultList = new ArrayList<int[]>
    while ((newLine = bufferReader.readLine()) != null) {
        String[] result = newLine.split("-");
        int numberOne = Character.getNumericValue(result[0]);
        int numberTwo = Character.getNumericValue(result[1]);
        if ((first >= numberOne && first <= numberTwo) && (second >= numberOne && second <= numberTwo)) {
            resultList.add(new int[2]{numberOne,nunumberTwo});
        }
    }
    if(!resultList.isEmpty()){
        int[] smallestInterval = null;
        int minInterval = 0;
        for(int[] result : resultList){
            int inerval = result[1]-result[0]
            if(smallestInterval==null || inerval < smallestInterval){
                minInterval = inerval;
                smallestInterval= result;
            }
        }
        System.out.println("Numbers are between " + smallestInterval[0] + " and " + smallestInterval[1]);
    }