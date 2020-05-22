if (has_return) {
    if (result.length() > 1)
        JSONArray resultReturn = result.getJSONObject(1).getJSONArray("round");
        sendVoyagesArrayBroadcast(owner + MyConstants.DIRECTION_RETURN, resultReturn);
    }
}