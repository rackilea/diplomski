AsyncTask {

// Declare fields so you can access from all methods within class if needed
TextView tvProdDetail1, tvProdDetail2;
String prodDet1, prodDetail2;

    preExecute(){
    // Initialize field variables
    tvProdDetail1 = (TextView) findViewById(R.id.my_tv_1);
    tvProdDetail2 = (TextView) findViewById(R.id. my_tv_2);
    } 

    doInBackground() {
    /Do network operations in background, set strings prodDetail1 and prodDetail2 to values retrieved from net
    } 

    post execute() {
    // set text() to TextViews
    tvProdDetail1.set text(prodDetail1);
    tvProdDetail2.set text(prodDetail2);
    }
}