try {

        JSONObject jsonObject = new JSONObject();


        JSONObject query = new JSONObject();
        jsonObject.put("query", query);


        JSONObject bool = new JSONObject();
        query.put("bool", bool);


        JSONArray must = new JSONArray();
        bool.put("must", must);


        JSONObject matchWrap = new JSONObject();

        JSONObject match = new JSONObject();
        match.put("customer.partnerName", "Synapse");

        matchWrap.put("match", match);

        must.put(matchWrap);


        JSONObject rangeWrap = new JSONObject();

        JSONObject range = new JSONObject();

        JSONObject customerBillingChargeAmount = new JSONObject();
        customerBillingChargeAmount.put("gte", 1);
        customerBillingChargeAmount.put("lte", 100);

        range.put("customer.billing.chargeAmount", customerBillingChargeAmount);

        rangeWrap.put("range", range);


        must.put(rangeWrap);




        JSONArray filter = new JSONArray();
        bool.put("filter", filter);


        JSONObject match2Wrap = new JSONObject();

        JSONObject match2 = new JSONObject();
        match2.put("customer.configId", 15);

        match2Wrap.put("match", match2);


        filter.put(match2Wrap);



        String jsonString2 = jsonObject.toString();

        // HERE THE SAME JSON STRING AS YOUR INPUT

    } catch (JSONException e) {
        e.printStackTrace();
    }