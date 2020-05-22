int step = 1;

for (int i = 255; i >= 0; i-=step) {
    String hex = Integer.toString(i, 16).toUpperCase();
    hex = hex + hex + hex;
    //output hex String
}