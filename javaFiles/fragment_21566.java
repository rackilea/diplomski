private final  myReceipt reprintReceipt;

public AsyncTaskName() {
    myReceipt reprintReceipt = new myReceipt();
}

@Override
protected List<String> doInBackground(String... urls) {
    return reprintReceipt.saveReprint(muncID);
}


@Override 
protected void onPostExecute(List<String> response) {
    if (response == null || response.isEmpty()){
        System.out.println("Failed Sending data");
        return;
    }

    if(response.get(0).equals("SUCCESS")){
    }
}