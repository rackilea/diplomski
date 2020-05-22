class Task extends SwingWorker<Void, Void>{
    @Override
    public Void doInBackground(){
        setProgress(0);

        //Create Backup Directory
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy_HMMSS");
        String timestamp = sdf.format(date);
        backupDir = backupDrive + ":\\" + "Backup_" + timestamp;
        File backupDirectory = new File(backupDir);
        backupDirectory.mkdir();

        //Copy Files
        //Main directories
        String pics = mainDrive + ":\\Users\\" + username + "\\Pictures\\";
        String docs = mainDrive + ":\\Users\\" + username + "\\Documents\\";
        String vids = mainDrive + ":\\Users\\" + username + "\\Videos\\";
        String musc = mainDrive + ":\\Users\\" + username + "\\Music\\";
        //Backup directories
        String bkPics = backupDir + "\\Pictures\\";
        String bkDocs = backupDir + "\\Documents\\";
        String bkVids = backupDir + "\\Documents\\";
        String bkMusc = backupDir + "\\Pictures\\";

        String[] directories = {pics, docs, vids, musc};
        String[] bkDirectories = {bkPics, bkDocs, bkVids, bkMusc};

        //Loop through directories and copy files
        for (int i = 0; i < directories.length; i++){
            File dir = new File(directories[i]);
            File dest = new File(bkDirectories[i]);
            for(File file: dir.listFiles()){
                try{
                    if(file.isFile()){
                        FileUtils.copyFileToDirectory(file, dest);
                        txtCopiedDirs.append(file.getAbsolutePath() + "\n");
                    } else if (file.isDirectory()){
                        FileUtils.copyDirectoryToDirectory(file, dest);
                        txtCopiedDirs.append(file.getAbsolutePath() + "\n");
                    }
                    if(getDirSize(file) >= ONE_PERCENT){
                        currentPercent = getDirSize(file)/ONE_PERCENT;
                        progressBar.setValue((int)currentPercent);
                        currentSize = 0;
                    } else {
                        currentSize = currentSize + getDirSize(file);
                        if(currentSize >= ONE_PERCENT){
                            currentPercent = currentSize/ONE_PERCENT;
                            currentPercent++;
                            progressBar.setValue((int)currentPercent);
                            currentSize = 0;
                        }
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    @Override
    public void done(){
        closeWindow();
    }
}