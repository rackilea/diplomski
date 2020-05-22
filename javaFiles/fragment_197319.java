JSONArray mainfoodlist = null;


    tipshealth = json.getJSONArray(TAG_RESPONSE);

        // looping through All RESPONSE
        for (int i = 0; i < tipshealth.length(); i++) {
        JSONObject jsonobj = tipshealth.getJSONObject(i);
        tipHealth = jsonobj.getString(KEY_HEALTHTIPS);

        listhealthtips.add(tipshealth.getJSONObject(i).getString("tips"));

        }