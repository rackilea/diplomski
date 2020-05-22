readData(new MyCallback() {
    @Override
    public void onCallback(List<Event> eventList) {
        Log.d("TAG", eventList.toString);
    }
});