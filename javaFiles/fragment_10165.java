List<File[]> fileList = new ArrayList<File[]>();
        int count = 0;
        for (int i = 0; i < fileList.size(); i++){
            count += fileList.get(i).length;
        }

        File[] finalFiles = new File[count];
        int pointer = 0;
        for (int i = 0; i < fileList.size(); i++){
            System.arraycopy(fileList.get(i), 0, finalFiles, pointer, fileList.get(i).length);
            pointer += fileList.get(i).length;
        }