public static void main(String args[])
    {
        //1. find current working dirrectory
        System.out.println(new File(".").getAbsolutePath());
        //2. paste fxml's to this directory or modify ../main/.. to absolute path
        //3. run program again?
        launch(args);
    }