ArrayList<Ball> balls;

private void removeVillianGroups(int color){
  for(int i = balls.size() - 1; i >= 0; i--){
        if(balls.get(i).getColor()==color){
            balls.remove(i);
        }
    }
}