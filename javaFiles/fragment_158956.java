@Override
protected void onPostExecute(String result) {

    if (dashStruct != null) {
        t.setText(dashStruct.getName());
        t2.setText(dashStruct.getMyHash());
        t3.setText(dashStruct.getPoolHash());
        t4.setText(dashStruct.getNetHash());
    } else {
        // Deal with dashStruct being null
    }
}