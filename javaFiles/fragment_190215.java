JSONStringer result = new JSONStringer();
JSONWriter array = result.array();

for (long i = start; i <= end; i = i + day) {
    ttm.put("$gte", "" + i);
    ttm.put("$lte", "" + (i + day));
    //code code code

    int count = statisticCollection.find(query).count();

    try {
        array.object().key("ttm").value(i).key("count").value(count).endObject();
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

try {
    array.endArray();
} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}