public int getRandomColor(int j){
  int color = randomNumber1.nextInt(8);
  colors[j] = color;

  while(j>1 && colors[j-1] == color && colors[j-2] == color){
    color = randomNumber1.nextInt(8);
    colors[j] = color;
  }
return color;
}