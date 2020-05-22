public static void main(String[] args) {
    int numOfBoxes = 5;
    boolean [] boxes = new boolean [numOfBoxes];
    for(int i = 2; i <= numOfBoxes; ++i){
      for(int j = i-1; j < numOfBoxes; j+=i){
        boxes[j] = !boxes[j];
      }
    }
    System.out.println(Arrays.toString(boxes));
}