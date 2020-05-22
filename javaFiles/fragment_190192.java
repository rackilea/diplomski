<E> List<E> spliceAndReverse(List<E> list, int startIndex, int endIndex){
        while(startIndex < endIndex){
            E e = list.get(startIndex);
            list.set(startIndex, list.get(endIndex));
            list.set(endIndex, e);
            startIndex++;
            endIndex--;
        }   
        return list;
    }