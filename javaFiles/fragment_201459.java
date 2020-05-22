private class FactCalculator extends AsyncTask<Void, Void, BigInteger> {
    int number = 0;

    public FactCalculator(int i) {
        this.number =i;
    }

    @Override
    protected BigInteger doInBackground(final Void... params){
        try{
            if(number>=0) {
                BigInteger res = new BigInteger("1");
                for (int i = number; i > 1; i--) {
                    res = res.multiply(BigInteger.valueOf(i));
                }
                return res;
            }
         } catch(Exception e){
             e.printStackTrace();
         }
         return null;
     }

     @Override
     protected void onPostExecute(final BigInteger result) {
         if (result != null) {
             TextView text = (TextView)findViewById(R.id.resultTextView);
             text.setText(result.toString());
         }
     }
 }