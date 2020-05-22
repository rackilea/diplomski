for(int i = 0; i < fruit.length; i++) {
  if(i == 0) {
    x = fruit[i];
  } else {
    x += "." + fruit[i];
  }
  System.out.println(x);
}