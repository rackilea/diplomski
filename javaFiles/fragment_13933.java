String json="{\"AREA\": [\"IT,SALES\"],\"CITY\": [\"LA\", \"NORTH\"]}";
JSONObject jsonOb = new JSONObject(json);
JSONArray arrJson=jsonOb.getJSONArray("AREA");

for(int i=0;i<arrJson.length();i++)
System.out.println(arrJson.getString(i));