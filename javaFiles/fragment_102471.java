Object process(Object possibleArray) {
    if (possibleArray instanceof Object[]) { // is array
        Object[] array = (Object[]) possibleArray;
        List<Object> list = new ArrayList<Object>(array.length);
        for(Object o : array) {
             list.add(process(o));
        }
        return list;
    } else {
        return possibleArray;
    }
}