String rawResponse = client.getResponse();
    JSONArray entries = null;
    JSONObject o = new JSONObject(rawResponse);
    entries = new JSONArray(o.getString("GetCampaignsInProgressListResult"));
    byte[] bArr = new byte[entries.length()];
    for (int i = 0; i < entries.length(); i++) {
        bArr[i] = (byte) entries.getInt(i);
    }