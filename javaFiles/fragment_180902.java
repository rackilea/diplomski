if (Config.Counter >= random ){

                    Random rand = new Random();
                    random = rand.nextInt((max - min + 1) + min);
                    new  InterstitialAdMobModel(activity);
                    Config.Counter = 0;
                }else{
                    Config.Counter ++;

                }