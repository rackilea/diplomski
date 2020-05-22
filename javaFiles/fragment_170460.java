Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
    //check if code has run before
    if(!hasRun){
        //this will run only once
        //by setting hasRun = true;
        hasRun=true;
        //add your code here...
    }
    //this code will run in every KeyFrame
    //add your code here...
    }));
    fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
    fiveSecondsWonder.play();