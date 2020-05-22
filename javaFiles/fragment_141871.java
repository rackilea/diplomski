public void onCameraViewStarted(int width, int height) {
    Log.d(TAG, "Prog: Trying to get robot cascade");

    File file = new File("./data/local/cascade.xml");
    boolean fileExists = file.exists();
    String fileDoesExist = String.valueOf(fileExists);

    Log.d(TAG, "Prog: Does the cascade file exist? "+fileDoesExist);

    robot_cascade = new CascadeClassifier("./data/local/cascade.xml");
    robot_cascade.load("./data/local/cascade.xml");
    String robot_cascade_name = "./data/local/cascade.xml";

    Log.d(TAG, "Prog: location is "+robot_cascade_name);

    if(robot_cascade.empty()){
        Log.d(TAG, "Prog: --(!)Error loading robot cascade");
    } else {
        Log.d(TAG, "Prog: --Holy smite the cascade is actually there praise the sun");
    }
    Log.d(TAG, "Prog: Made it through loading cascade!");
}