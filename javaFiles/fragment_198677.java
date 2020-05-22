protected void onPostExecute(String result) {
         // Pass the result data back to the main activity
        gpu2dcurent = result;
         //Toast.makeText(getBaseContext(), result,
                //Toast.LENGTH_SHORT).show();
         gpu.this.data = result;  
         if (gpu.this.pd != null) {
             //gpu.this.pd.dismiss();
         }
      tx.setText(gpu2dcurent);
     }
    }