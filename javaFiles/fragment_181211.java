static final public String UPDATE_TIME = "UPDATE_TIME";
static final public String UPDATED_TIME = "UPDATED_TIME";

public void updateTextView(String time) {
    Intent intent = new Intent(UPDATE_TIME);
    if(time != null)
        intent.putExtra(UPDATED_TIME, time);
    broadcastManager.sendBroadcast(intent);
}