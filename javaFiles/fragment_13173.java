JSONObject json=null;
            try{
            json=new JSONObject(extrasMenu.getAncillary().get(i));
        }
        catch(org.json.JSONException e){
                int len=extrasMenu.getAncillary().toString().length();
                json=new JSONObject(extrasMenu.getAncillary().toString());
        }