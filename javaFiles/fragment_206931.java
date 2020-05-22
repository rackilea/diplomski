static void format(List<Integer> numberList,int columnSize){

        int totalLength = numberList.size();
        int index=0;
        for(; (index+columnSize) <= totalLength ;index+=columnSize ){
            System.out.println(String.format(getRowFormat(columnSize), numberList.subList(index, index+columnSize).toArray()));
            //or use this
            //System.out.printf(rowFormat.toString()+"\n", numberList.subList(i, i+columnSize).toArray());
        }
        if(index <= totalLength){//to handle pending values if any.
            System.out.println(String.format(getRowFormat(totalLength - index), numberList.subList(index, totalLength).toArray()));
        }
    }
    //handling format
    private static String getRowFormat(int columnSize) {
        StringBuilder rowFormat = new StringBuilder();
        for(int j=0;j<columnSize;j++){
            rowFormat.append("%10d");
        }
        return rowFormat.toString();
    }