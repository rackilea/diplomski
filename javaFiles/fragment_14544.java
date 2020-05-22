while(index >=0){
  System.out.println("looping");
  int len = jtf.length();
  hilit.addHighlight(index,index+len, painter);
  index = jta.indexOf(jtf, index+len);
}