File sdCard = Environment.getExternalStorageDirectory();

File images = new File (sdCard.getAbsolutePath() + "/foto");


  File[] imagelist = images.listFiles(new FilenameFilter(){  
        @override  
        public boolean accept(File dir, String name)  
        {  
            return ((name.endsWith(".jpg"))||(name.endsWith(".png"))  
        }  
    });  
        urls = new String[imagelist.length];  

        for(int i= 0 ; i< imagelist.length; i++)  
        {  
            urls[i] = imagelist[i].getAbsolutePath();  
        }