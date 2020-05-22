Process sh = Runtime.getRuntime().exec("su", null,null);

                    OutputStream  os = sh.getOutputStream();
                    os.write(("/system/bin/screencap -p " + "/sdcard/img.png").getBytes("ASCII"));
                    os.flush();

                    os.close();
                    sh.waitFor();