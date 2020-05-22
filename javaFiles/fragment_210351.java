new Thread(new Runnable() {
    @Override
    public void run() {
        StudE.sendToDatabase("INSERT INTO tblSHARED VALUES(?, ?);", username, input);
    }
}).start();

StudE.toast(getResources().getString(R.string.folder_retrieved_successfully), activity);