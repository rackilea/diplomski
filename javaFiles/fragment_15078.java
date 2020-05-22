// t is an instance of Template
final Map<String,String>           params = t.getParameters();
Iterator<Map.Entry<String,String>> it     = params.entrySet().iterator();

Map.Entry<String,String> param;
int i;
for (i=0, param = it.hasNext() ? it.next() : null ; param != null ; i++, param = it.hasNext() ? it.next() : null) {
    Label     label = new Label();
    TextField field = new TextField(param.getValue());

    final String key = param.getKey();
    field.textProperty().addListener((ObservableValue<? extends String> obs, String oldValue, String newValue) -> params.put(key,newValue));
    // unrelevant code
}