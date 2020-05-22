mPlayer.addNotificationCallback(new Player.NotificationCallback() {

                            @Override
                            public void onPlaybackEvent(PlayerEvent playerEvent) {

                                if(playerEvent==PlayerEvent.kSpPlaybackNotifyTrackDelivered){


                                Toast.makeText(PlaySong.this,"Delivered",Toast.LENGTH_LONG).show();
                                System.out.println("Delivered");



                            }

                            @Override
                            public void onPlaybackError(Error error) {

                            }
                        });