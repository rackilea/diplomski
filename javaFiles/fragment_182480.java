JSONArray packsJSON  = new JSONArray();
    JSONObject innerObject;
    for(PackageList packageList:selecteditem)
    {
        innerObject=new JSONObject();
        innerObject.put("pack_id",packageList.getSubs_id());
        innerObject.put("pack_dsc", packageList.getSubs_desc());
        innerObject.put("pack_tax_amt", packageList.getTax_amnt());
        innerObject.put("pack_grand_total", packageList.getSubs_grnd_tot_prc());


        Log.i("INNEROBJECT","hyu"+innerObject);

        packsJSON.put(innerObject);

        Log.i("PACKJSON","nkd==>>"+packsJSON)
    }