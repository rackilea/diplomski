runOnUiThread(new Runnable() {
                        public void run() {
                            if (response.getStatusLine().getStatusCode() != 200) {
                                Toast errorToast = Toast.makeText(NewsActivity.this, "Error, pls chech your internet connection and try again!", Toast.LENGTH_SHORT);
                                errorToast.show();
                            }

                        }
                    });