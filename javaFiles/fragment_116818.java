try {
                    mp.setDataSource(context.getApplicationContext(), soundUri);
                    mp.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
                    mp.prepare();
                    mp.start();
                } catch (Exception e) {
                    //exception caught in the end zone
                }