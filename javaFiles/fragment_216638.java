public class MainApplet extends JApplet {
    public MainApplet() {
    }
    public void init() {
        // constructor 

        setSize(800,600);
        getContentPane().setLayout(null);

        AppSettings AppSettings = new AppSettings();
        AppSettings.Username = GetParameter(0);
        AppSettings.Password = GetParameter(1);
        AppSettings.ClientMode = GetParameter(2);
        AppSettings.ServerIP = GetParameter(3);

        System.out.println("Main applet loaded.");
        System.out.println("Starting load...");

        final LoadingDialog load = new LoadingDialog();
        load.setVisible(true);
        getContentPane().add(load);

        int panelX = (getWidth() - load.getWidth() - getInsets().left - getInsets().right) / 2;
        int panelY = ((getHeight() - load.getHeight() - getInsets().top - getInsets().bottom) / 2);
        load.setLocation(panelX, panelY);

        load.lblNewLabel_1.setText("Connecting...");

        // UPDATE PROGRESS BAR //
        load.progressBar.setValue(15);

        Thread thread = new Thread() {
            public void run() {
                Connect connect = new Connect();
                String Result = null;
                try {
                    Result = connect.Read("http://www.world2build.com/");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(Result == null) {
                    return;
                }

                // UPDATE PROGRESS BAR //
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        load.progressBar.setValue(30);
                        load.lblNewLabel_1.setText("Checking for updates...");
                    }
                });

                String UpdatesAvailable = "null";

                try {
                    UpdatesAvailable = connect.Read("http://test.world2build.com/Game/CheckUpdates.aspx?v=" + AppSettings.Version);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // UPDATE PROGRESS BAR //
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        load.progressBar.setValue(60);
                    }
                });

                if(UpdatesAvailable.startsWith("available")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            load.lblNewLabel.setText("Updating, please wait...");
                            load.lblNewLabel_1.setText("Downloading...");
                        }
                    });

                    URL url;
                    try {
                        url = new URL("http://www.world2build.com/Game/WorldToBuild.zip");

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        InputStream in = connection.getInputStream();
                        FileOutputStream out = new FileOutputStream(System.getenv("APPDATA") + "download.zip");
                        copy(in, out, 1024);
                        out.close();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(UpdatesAvailable.startsWith("unavailable")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            load.lblNewLabel.setText("Please wait...");
                            load.lblNewLabel_1.setText("Logging in...");
                        }
                    });
                    String loginStatus = null;

                    try {
                        loginStatus = connect.Read(
                                "http://test.world2build.com/Game/Login.ashx?u="
                                + AppSettings.Username + "&p="
                                + AppSettings.Password + "&sip="
                                + AppSettings.ServerIP);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if(loginStatus.startsWith("success")) {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                load.lblNewLabel_1.setText("Connecting...");
                                load.progressBar.setValue(100);
                            }
                        });

                        // Join the game. Start game now. //


                    }
                    else if(loginStatus.startsWith("failed")) {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                load.lblNewLabel.setText("An error occured");
                                load.lblNewLabel_1.setText("Login failed.");
                            }
                        });
                    }
                    else {
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
                                load.lblNewLabel.setText("An error occured");
                                load.lblNewLabel_1.setText("Failed to connect.");
                            }
                        });
                    }
                }
                else {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            load.lblNewLabel.setText("An error occured");
                            load.lblNewLabel_1.setText("Failed to check updates.");
                        }
                    }

                }
            }

            Connect connect = new Connect();
            String Result = null;
            try {
                Result = connect.Read("http://www.world2build.com/");
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(Result == null) {
                return;
            }

            // UPDATE PROGRESS BAR //
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    load.progressBar.setValue(30);
                    load.lblNewLabel_1.setText("Checking for updates...");
                }
            });

            //wait(1);

            String UpdatesAvailable = "null";

            try {
                UpdatesAvailable = connect.Read("http://test.world2build.com/Game/CheckUpdates.aspx?v=" + AppSettings.Version);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // UPDATE PROGRESS BAR //
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    load.progressBar.setValue(60);
                }
            });

            if(UpdatesAvailable.startsWith("available")) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        load.lblNewLabel.setText("Updating, please wait...");
                        load.lblNewLabel_1.setText("Downloading...");
                    }
                });

                URL url;
                try {
                    url = new URL("http://www.world2build.com/Game/WorldToBuild.zip");

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream in = connection.getInputStream();
                    FileOutputStream out = new FileOutputStream(System.getenv("APPDATA") + "download.zip");
                    copy(in, out, 1024);
                    out.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(UpdatesAvailable.startsWith("unavailable")) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        load.lblNewLabel.setText("Please wait...");
                        load.lblNewLabel_1.setText("Logging in...");
                    }
                });
                String loginStatus = null;

                try {
                    loginStatus = connect.Read(
                            "http://test.world2build.com/Game/Login.ashx?u="
                            + AppSettings.Username + "&p="
                            + AppSettings.Password + "&sip="
                            + AppSettings.ServerIP);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(loginStatus.startsWith("success")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            load.lblNewLabel_1.setText("Connecting...");
                            load.progressBar.setValue(100);
                        }
                    });

                    // Join the game. Start game now. //


                }
                else if(loginStatus.startsWith("failed")) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            load.lblNewLabel.setText("An error occured");
                            load.lblNewLabel_1.setText("Login failed.");
                        }
                    });
                }
                else {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            load.lblNewLabel.setText("An error occured");
                            load.lblNewLabel_1.setText("Failed to connect.");
                        }
                    });
                }
            }
            else {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        load.lblNewLabel.setText("An error occured");
                        load.lblNewLabel_1.setText("Failed to check updates.");
                    }
                });
            }
        }
        thread.start();
    }
    // ...
}