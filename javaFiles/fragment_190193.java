static <E> List<E> spliceAndReverseUsingSubList(List<E> list, int startIndex, int endIndex){
        List<E> subList =  list.subList(startIndex, endIndex+1);
        Collections.reverse(subList);
        List<E> resultList = new ArrayList<>(list.subList(0, startIndex));
        resultList.addAll(subList);
        if(list.size() != endIndex+1){
        resultList.addAll(list.subList(endIndex+1, list.size()));
        }
        return resultList;
    }