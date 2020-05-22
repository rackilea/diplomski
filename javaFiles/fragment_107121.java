try {
        JSONObject jsonObj = new JSONObject("{\"count\":3939,\"has_more\":true,\"map_location\":{\"lat\":0.60996950000000183,\"lon\":-27.568517000000003,\"panoramio_zoom\":16},\"photos\":[{\"height\":375,}]}");

        System.out.println(jsonObj);
    } catch (JSONException e) {
        //some exception handler code.
    }