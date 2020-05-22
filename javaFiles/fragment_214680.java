JSONArray jArr2 = new JSONArray(jsonString2);

List<String> titleNames = new ArrayList<>();

for (int i = 0; i < jArr2.length(); i++) {

    titleNames.add(jArr2.getJSONObject(i).getString("titleName"))

}