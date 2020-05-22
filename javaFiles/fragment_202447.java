/**
     * 
     * @param filename is the video full file path stored at any location of the system 
     * @return the value containing the time format of the video file
     */
    public static String getDurationInString(String filename)
    {
        try {
            //
            long ms=getDuration(new File(filename));
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(ms),
                    TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)),
                    TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
            //System.out.println(hms);
            return hms;
        } catch (IOException ex) {
            Logger.getLogger(VideoInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }


    /**
     * 
     * @param file : file that specify the file in the File location
     * @return the duration in long 
     * @throws IOException if any exception is thrown by the system 
     */
    public static long getDuration(File file) throws IOException {
        PlayerControl playerControl = PlayerFactory.createLightweightMPEG4Player();
        playerControl.open(file.getAbsolutePath());
        return playerControl.getDuration();
    }