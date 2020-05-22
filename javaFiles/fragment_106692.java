scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
                public void run() {

                    connectivityManager.registerNetworkCallback(
                            builder.build(),
                            new ConnectivityManager.NetworkCallback() {
                                @Override
                                public void onAvailable(Network network) {

                                    if(isOnline()){
                                        NetworkStatus.setImageResource(R.drawable.network_circle_on);
                                    }
                                    else
                                    {
                                        NetworkStatus.setImageResource(R.drawable.network_circle_off);

                                    }
                                }

                                @Override
                                public void onLost(Network network) {

                                    NetworkStatus.setImageResource(R.drawable.network_circle_off);
                                }
                            }

                    );

                }
            }, 0, 4, TimeUnit.SECONDS);