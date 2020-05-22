String statusSeverityDescription;
for (int j = 0; j < len; j++) {                                
   JSONObject o = arrayStatus.getJSONObject(j);
   statusSeverityDescription = o.optString(
                                        "statusSeverityDescription", "");
}