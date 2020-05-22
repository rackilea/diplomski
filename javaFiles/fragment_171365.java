JSONObject jsonObj = new JSONObject();

String[] tempArray = new String[] {
        "email", "test@test.com"
};
if (tempArray.length % 2 == 0) {
    int i = 0;
    while (i < tempArray.length) {
        String key = tempArray[i];
        String value = tempArray[i + 1];
        jsonObj.put(key, value);
        i += 2;
    }
}
String jsonContent = jsonObj.toString(4);
System.out.println("jsonContent = " + jsonContent);