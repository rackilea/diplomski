public void showResult(){
            mRunnable = new Runnable() {
                @Override
                public void run() {
                    int rand = (int)(Math.random()* moodResults.length);
                    result.setText(moodResults[rand]);
                    int randomInt = r.nextInt(imageIds.length);
                    thumbprint.setBackgroundResource(imageIds[randomInt]); //thumbprint is your Imageview
                    //stop animation
                    thumbAnimation.stop();
                    mHandler.postDelayed(mRunnable, 5000);//This causes hanlder to called again in 5 seconds
                }
            };

            mHandler.postDelayed(mRunnable, 5000); //Here handler is called the first time; the code in mRunnable will execute after 5 seconds 
        }