public void run() {

                    if (!isFinishing() && mInterstitialAd.isLoaded()) {

                        mInterstitialAd.show();
                    } else if(isFinishing()){

                        scheduler.shutdown();
                    }
                    else{
                        Log.d("TAG"," Interstitial not loaded");   
                    }

                }