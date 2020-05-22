Thread test = new Thread() {
    public void run() {
            try {
                final String reply = bluetoothConnector.readSingleMessage();
                currentAct.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listItems.add("other:" + String.valueOf(times));
                        listItems.add("other:" + reply);
                        itemsAdapter.notifyDataSetChanged();
                    }
                });
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
};