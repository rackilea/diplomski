// Loads the JSON (assuming you provide it as a string).
JSONObject x = new JSONObject(...);
// Gets and stores a reference to the outer object.
JSONObject y = x.getJSONObject("CfgCampaign");
// Now you can access any of the nested fields as follows.
JSONObject z = y.getJSONObject("campaignGroups");