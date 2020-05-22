HashMap<String, Folder> folders = new HashMap<>();

    public void listAllMusicFiles(String pathToDirectory) {

        int mp3Count = 0;
        File f = new File(pathToDirectory);
        File[] files = f.listFiles();

        Folder folder;
        String folderName, folderPath;

        for (File inFile : files) {
            if (inFile.isDirectory()) {
                //reset last folder path
                Log.d("Directory ", inFile.getPath());
                listAllMusicFiles(inFile.getPath());
            } else {
                if (inFile.getAbsolutePath().endsWith(".mp3") || inFile.getAbsolutePath().endsWith(".MP3")) {
                    mp3Count++;
                    Log.wtf("MP3 Count", mp3Count + " ");

                    //add each folder only once
                    folderName = inFile.getParentFile().getName();
                    folderPath = inFile.getParentFile().getPath();

                    Log.e("FOUND in", folderPath);

                    if (folders.containsKey(folderPath)) {

                        folder = folders.get(folderPath);
                        folder.setFolder_Song_Count(mp3Count + "");
                        folders.put(folderPath, folder);
                    } else {

                        folder = new Folder(folderName, folderPath, mp3Count + "");
                        folders.put(folderPath, folder);
                    }

                }
            }
        }
    }