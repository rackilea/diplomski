liveToggle
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView,
                            boolean isChecked) {
                        if (isChecked) {
                            directoryEntries.clear();

                            FTPClient client = new FTPClient();

                            try {
                                client.connect(address);
                                client.login(username, password);

                                //
                                // Obtain a list of filenames in the current
                                // working
                                // directory. When no file found an empty array
                                // will
                                // be returned.
                                //
                                String[] names = client.listNames();
                                Drawable currentIcon = null;
                                for (String name : names) {
                                    File tmpFile = new File(name);
                                    String fileName = tmpFile.getName();
                                    if (checkEndsWithInStringArray(
                                            fileName,
                                            getResources().getStringArray(
                                                    R.array.fileEndingJs))) {
                                        currentIcon = getResources()
                                                .getDrawable(R.drawable.mimejs);
                                    } else if (checkEndsWithInStringArray(
                                            fileName,
                                            getResources().getStringArray(
                                                    R.array.fileEndingHTML))) {
                                        currentIcon = getResources()
                                                .getDrawable(
                                                        R.drawable.mimehtml);
                                    } else if (checkEndsWithInStringArray(
                                            fileName,
                                            getResources().getStringArray(
                                                    R.array.fileEndingCSS))) {
                                        currentIcon = getResources()
                                                .getDrawable(R.drawable.mimecss);
                                    } else if (checkEndsWithInStringArray(
                                            fileName,
                                            getResources().getStringArray(
                                                    R.array.fileEndingXML))) {
                                        currentIcon = getResources()
                                                .getDrawable(R.drawable.mimexml);
                                    } else if (checkEndsWithInStringArray(
                                            fileName,
                                            getResources().getStringArray(
                                                    R.array.fileEndingPhp))) {
                                        currentIcon = getResources()
                                                .getDrawable(R.drawable.mimephp);
                                    } else {
                                        currentIcon = getResources()
                                                .getDrawable(R.drawable.mimetxt);
                                    }
                                    directoryEntries.add(new IconifiedText(
                                            tmpFile.getPath(), currentIcon));
                                    System.out.println("Name = " + name);
                                }
                                FTPFile[] ftpFiles = client.listFiles();
                                for (FTPFile ftpFile : ftpFiles) {
                                    //
                                    // Check if FTPFile is a regular file
                                    //
                                    if (ftpFile.getType() == FTPFile.FILE_TYPE) {
                                        System.out.println("FTPFile: "
                                                + ftpFile.getName()
                                                + "; "
                                                + FileUtils
                                                        .byteCountToDisplaySize(ftpFile
                                                                .getSize()));
                                    }
                                }
                                client.logout();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    client.disconnect();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                });