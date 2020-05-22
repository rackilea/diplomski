Map<String, Object> mapObj = new Gson().fromJson(
    jsonObject, new TypeToken<HashMap<String, Object>>() {}.getType());

LinkedTreeMap<String, Object> requiredMapObj = (LinkedTreeMap<String, Object>) mapObj.get("data");

String strValue = (String) requiredMapObj.get("estimate_time");

String numberValueAlone = strValue.replaceAll("[^0-9]", "");