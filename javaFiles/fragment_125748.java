public static void merge(Sports obj, List<Sports> source){
        int index = source.indexOf(obj);
        if(index == -1) {
            source.add(obj);
            return;
        }
        Sports tempObj = source.get(index);
        tempObj.setValue(obj.getValue() + tempObj.getValue());
}