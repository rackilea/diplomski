//in main
String[] launchArgs = new String[] {"Width=800", "Height=600"};
Window.launch(Window.class, launchArgs);

..........................


//in start(Stage)

String[] args = getParameters();
for (String s : args) {
     if (s.contains("Width")) {
        //parse and set the window width here
     }
}