List<GameObject> toAdd = new ArrayList<>();
for(GameObject t : list){
  if(Enemy.count < 20){
    toAdd.add(new Enemy(100, 100, true));
  }
}
list.addAll(toAdd);