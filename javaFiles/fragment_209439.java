class Dictionary {
    Map<Integer, Map<WeekDay, Map<String, Data>>> obj;

    getDataDto(Integer key, Weekday weekDay, String str) {
        final Data data = obj.get(key).get(weekDay).get(str);
        return (new Function<Data, DataDto>() {
            ...
        }).apply(data);
    }
}