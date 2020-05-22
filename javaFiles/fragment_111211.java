public void checkMouseWheel() {
if (highLight != null) {
    int dWheel = Mouse.getDWheel();
    if (dWheel < 0) {
        System.out.println("DOWN");
    } else if (dWheel > 0){
        System.out.println("UP");
   }
}