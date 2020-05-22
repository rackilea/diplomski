final Date date = new Date();
            final SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
            final File dir;
            Boolean canWrite = Environment.getExternalStorageDirectory().canWrite();
            if (canWrite) {
                dir = new File(Environment.getExternalStorageDirectory() + "/myFolder" + "/" + mDate[2] + "-" + mDate[1] + "-" + mDate[0]);
            } else {
                dir = new File(Environment.getRootDirectory() + "/myFolder" + "/" + mDate[2] + "-" + mDate[1] + "-" + mDate[0]);
            }
            dir.mkdirs();
            myRecorder = new MediaRecorder();
            myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            myRecorder.setOutputFile(String.valueOf(dir) + "/" + dateFormat.format(date) + ".amr");