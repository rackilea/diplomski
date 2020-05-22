private ArrayList<ImageView> makeImageViewArr(File imagesDir) { 

    File[] strImageList = imagesDir.listFiles();
    myMouseHandler mouseHandler = new myMouseHandler();

    //instantiate imageview arraylist
    arrImageList = new ArrayList<ImageView>();

    //get files from folder & start at 1 to ignore ds.Store
    for( int count = 1; count < strImageList.length; count++ ) {
        ImageView imgView = new ImageView( strImageList[ count ].toURI().toString() );
        imgView.setOnMouseClicked( mouseHandler );
        imgView.setFitHeight(500);
        imgView.setFitWidth(500);
        imgView.setPreserveRation(true);
        arrImageList.add( imgView );
    }
    return arrImageList;
}