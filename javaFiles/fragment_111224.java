Toast toast = new Toast(this);
            TextView textView=new TextView(this);
            textView.setTextColor(Color.BLUE);
            textView.setBackgroundColor(Color.TRANSPARENT);
            textView.setTextSize(20);
            textView.setText("My Toast For Long Time");
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

            toast.setView(textView);

          timer =new CountDownTimer(20000, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    toast.show();
                }
                public void onFinish()
                {
                    toast.cancel();
                }

            }.start();