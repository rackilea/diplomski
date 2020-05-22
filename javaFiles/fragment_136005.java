"-fx-bar-fill: rgb({0});"
+ "-fx-background-color: "
+ "linear-gradient(from 0% 0% to 0% 100%, " // start bg1
+ "derive(-fx-bar-fill, -30%), derive(-fx-bar-fill, -40%)),"
+ "linear-gradient(from 0% 0% to 0% 100%, " // start bg2
+ "derive(-fx-bar-fill, 80%), derive(-fx-bar-fill, 0%)),"
+ "linear-gradient(from 0% 0% to 0% 100%, " // start bg3
+ "derive(-fx-bar-fill, 30%), derive(-fx-bar-fill, -10%));"
+ "-fx-background-insets: 0,1,2;" // reducing drawing area for each bg
+ "-fx-background-radius: 5 5 0 0, 4 4 0 0, 3 3 0 0;"