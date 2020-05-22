private void run(){
        File tmpFile = getFile();
        System.out.println(tmpFile.getAbsolutePath());
    }

    private File getFile() {
        return jFileChooser.getSelectedFile();
    }