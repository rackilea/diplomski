class MyTask extends AsyncTask<Void,String,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try {
                int num = 1;
                int aleatorio;
                while(num<4) {

                    Random r = new Random();
                    aleatorio = r.nextInt(frasesCarga.size() - 1);
                    publishProgress(frasesCarga.get(aleatorio));
                    num++;
                    frasesCarga.remove(aleatorio);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            fraseCarga.setText(values[0]);
        }
    }