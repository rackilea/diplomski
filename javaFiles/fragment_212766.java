Object obj = parser.parse(new FileReader(settingsFileName));
JSONObject jsonObject = (JSONObject) obj;

int[] dataGrid = new int[11];
int i = 0;
JSONArray msg = (JSONArray) jsonObject.get("data");
Iterator<Object> iterator = msg.iterator();
while (iterator.hasNext()) {
    Number num = (Number) (iterator.next());
    dataGrid[i] = number.intValue();
    i++;
}