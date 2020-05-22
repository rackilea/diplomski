if (!boost.isPlaying())
                        {
                            boost= new MediaPlayer();
                        }
                        try {
AssetFileDescriptor afd = res.openRawResourceFd(R.raw.boost);

                           boost.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                            boost.prepare();
                            boost.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }