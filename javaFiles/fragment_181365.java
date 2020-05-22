public void onResponse(String response) {
    //Log.i("Responses", response);
    ArrayList<Deal> deals = new JsonConverter<Deal>().toArrayList(response, Deal.class);
    adapter.addAll(deals);
    stopAnim();
}