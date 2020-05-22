List<String> newSortedList = new ArrayList<String>();

        for(String currentSortedStr:sortedList){

            if(unsortedList.size==0)break;

            if(unsortedList.remove(currentSortedStr)){
                newSortedList.add(currentSortedStr);
            }
        }