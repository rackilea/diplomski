new Handler().postDelayed(new Runnable(){
        @Override
        public void run() {
              Intent intent = new Intent(Palet_result.this, Rpalet_result.class);
              startActivity(intent);                                                

        }

   }, 5000);