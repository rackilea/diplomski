while((s = in.readLine()) != null && !s.isEmpty()) {
    final String line = s ;
    Platform.runLater(() -> {
         switch (line)
         {
             case "red":
                 //set circle to red.
                 red.setFill(Paint.valueOf("#ff1f1f"));
                 System.out.println("red");
                 break;
             case "yellow":
                 //set circle to yellow
                 yellow.setFill(Paint.valueOf("#36bc0d"));
                 System.out.println("yellow");
                 break;
             case "green":
                 //set circle to green
                 green.setFill(Paint.valueOf("#bdff1f"));
                 System.out.println("green");
                 break;
             default:
                 break;
         }
    });
}