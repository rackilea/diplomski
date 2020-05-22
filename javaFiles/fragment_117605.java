public static int getDurationFromJSON(String json){
    try {
        Gson gson = new Gson();
        DirectionMatrixResult result = gson.fromJson(json, DirectionMatrixResult.class);
        return (int)(result.getRows()[0].getElements()[0].getDuration().getValue() / 60.0f + 0.0f);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return -1;
}