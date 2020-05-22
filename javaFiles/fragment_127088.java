Bird[] birds = new Bird[2];
String[] birdNames = {"falcon", "eagle"};

for (int i = 0; i < birds.length; i++){
    birds[i] = new Bird(birdNames[i]);
    System.out.println(birds[i]);
}