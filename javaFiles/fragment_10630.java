(new Thread(new Runnable() {

            @Override
            public void run() {

                TextView textView = (TextView) findViewById(R.id.text);

                Runnable one = new Runnable(){
                    @Override
                    public void run() {
                        textView.setText("0.0");
                    }
                };

                Activity.runOnUiThread(one);

                InputStream inputStream;
                URL url = null;
                InputStreamReader inputStreamReader;
                char c;
                String s = "";
                try {

                    url = new URL ("https://www.blank.org/");
                    inputStream = url.openConnection().getInputStream();
                    inputStreamReader = new InputStreamReader(inputStream);
                    do{
                        c = (char) inputStreamReader.read();
                        s+= c;
                    }while (c!=-1);


                    Runnable two = new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(":)");
                        }
                    };

                    Activity.runOnUiThread(two);

                }catch (Exception E){


                    Runnable three = new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(":(");
                        }
                    };

                    Activity.runOnUiThread(three);

                    Log.i("Error", ":(");
                }

            }
        })).start();