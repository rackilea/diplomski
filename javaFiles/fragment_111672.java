//Checks if the specified directory exists.
                    File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "PSync");

                    //Saves this path to be used later.
                    String bkPath = directory.getPath().toString();

                    //Checks if the directory exists. If it does not, then it creates it.
                    if (directory.exists()) {
                    } else {
                        Boolean success = directory.mkdirs();
                        if (success) {
                          Log.e(directory.getPath(), "Directory successfully created");
                        } else {
                            Log.e(directory.getPath(), "Directory creation failed.");
                        }
                    }