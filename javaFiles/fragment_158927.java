for(int i=1; i<list.size(); i++) {
  if(Math.abs(list.get(i).speed - list.get(i-1).speed) < 3) {
    list.get(i-1).time = (list.get(i).time + list.get(i-1).time) / 2;
    list.get(i-1).speed = (list.get(i).speed + list.get(i-1).speed) / 2;
    list.remove(i);
  }
}