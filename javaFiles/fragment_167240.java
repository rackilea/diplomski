public enum HistoryUpdateTypeEnum {

    OBJECTS {
        @Override
        Object getJson(Document data) {
            return data.get("objects");
        }
    },

    ...

    abstract Object getJson(Document data);
}