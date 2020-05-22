public class startTestAsync extends AsyncTask<Double, Void, Void> {
        double[] timeArray = new double[500]; // set array
        double rating = 0;
        double lagStartTime;
        double lagEndTime;
        double lagTimeResult;
        int testAmount;
        int cnt;
        @Override
        protected Void doInBackground(Double...grayVal) {

            for (testAmount = 0; testAmount < 5000; testAmount++) {

                Log.i("Mat Value Async", String.valueOf(grayValGlobal));
                lagStartTime = System.nanoTime(); //start lagTimer start
                    }
            }
            return null;
        }
        protected void onPostExecute(Long result) {
            //Do something
        }

    }