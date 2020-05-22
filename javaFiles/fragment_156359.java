String jsoncontent=restTemplate.getForObject(constr+"getAssetdata/{Id}", String.class, curAcct.getiD());
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Assets.class, new AssetDeserialiser());
        final Gson gson = gsonBuilder.create();
       Assets assetAcc = gson.fromJson(jsoncontent, Assets.class);
        JSONObject jsonObj=new JSONObject(jsoncontent);
        assetAcc.setKeyValueData(jsonObj.getString("keyValueData"));