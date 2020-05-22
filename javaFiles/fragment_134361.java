private List<T> convertToObjectList(List<Map<String, String>> csvRecordMapList, Class<T> targetClass)
    throws IllegalAccessException, InvocationTargetException, InstantiationException {
    List<T> csvRecordObjList = new ArrayList<>();
    ConvertUtils.register(getDateConverter(), Date.class);
    for (Map<String, String> recordMap : csvRecordMapList) {
        T targetClassObj = targetClass.newInstance();
        BeanUtils.populate(targetClassObj, recordMap);
        csvRecordObjList.add(targetClassObj);
    }

    return csvRecordObjList;
}