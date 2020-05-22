JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);


    if (returnValue == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        int pos2 = selectedFile.getAbsolutePath().lastIndexOf(selectedFile.getName());
        String path = null;
        path = selectedFile.getAbsolutePath().replace(selectedFile.getName(), "");
        File file = new File(path);
        URL[] urls = null;
        try {
            urls=new URL[]{
                    file.toURI().toURL()
                    };} 
        catch (MalformedURLException e){// TODO Auto-generated catch block
                    e.printStackTrace();
                }
        String fileName = selectedFile.getName();
        int pos = fileName.lastIndexOf(".");
        if(pos > 0){
            fileName = fileName.substring(0,pos);
        }
        ClassLoader loader = new URLClassLoader(urls);
        bundle = ResourceBundle.getBundle(fileName, Locale.getDefault(), loader);
        }