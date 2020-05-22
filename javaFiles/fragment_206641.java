timer = new Timer();
task = new Sender();

public startTimer() {
    if(task != null) {
        timer.scheduleAtFixedRate(task, 200);
    }
}
public stopTimer() {
    timer.cancel();
}
private class Sender extends TimerTask {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if (mCommandService.getState() != CommandService.STATE_CONNECTED) {
            Toast.makeText(this, R.string.title_not_connected, Toast.LENGTH_SHORT).show();
            return;
        }
        if (message.length() > 0) {
            byte[] send = message.getBytes();
            mCommandService.write(send);
            mOutStringBuffer.setLength(0);
            mOutEditText.setText(mOutStringBuffer);
        }
    }

}