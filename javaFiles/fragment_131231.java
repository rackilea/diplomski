if (CheckInternetConection.isInternetConnection(SplashScreenActivity.this)) {
 Intent emailIntent = new Intent(Intent.ACTION_SEND);
                                    emailIntent.setType("vnd.android.cursor.dir/email");
                                    String to[] = {"bugfreeRam@gmail.com"};
                                    emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
                                    emailIntent.putExtra(Intent.EXTRA_STREAM, path);
                                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Database File");
                                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
 } else {

                                    new SweetAlertDialog(SplashScreenActivity.this)
                                            .setTitleText("Alert!")
                                            .setContentText(getResources().getString(R.string.app_connection))
                                            .show();
                                }