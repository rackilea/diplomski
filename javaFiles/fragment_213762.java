int counter = 0;
int i;
for(i = 1; i <= 20; i++){ 
  if(counter == 4) {
    counter = 0;
  }
  if(counter < 2) {
    System.out.println(i);
  }
  if(counter > 1 && counter < 4) {
    System.out.println("*");
  }
  counter++;
}