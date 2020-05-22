String filePath = null;
    File file = null;
    FileInputStream inputStream = null;
try {
           filePath = getCacheDir() + "/exampleout.mid";
           file = new File(filePath);

           inputStream = new FileInputStream(file);
           if(inputStream.getFD().valid())
           {
               System.out.println("Valid!");
           }
        } catch (Exception e1) {
            e1.printStackTrace();
            System.exit(-1);
        }

       try {
         mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(inputStream.getFD());
        inputStream.close();
    } catch (Exception e1) {
        e1.printStackTrace();
        System.exit(-1);
    }

    try {
        mediaPlayer.prepare();
    } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }