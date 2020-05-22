btnSend.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){
           String t = new String("http://myhttprequest");
           Request r = new Request(ma){
               protected void onPostExecute(String result){
                   editText.setText(result);
                   lv.setAdapter(result);
                   arrList.add(result);
                   arrAdapter.result();
               }
          };

     }
});