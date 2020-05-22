public void moveShot() { 
    for (int i = 0; i < Shot.size(); i++) {
        Shot.get(i).x -= 10;
        Shot.get(i).y += 5;
    }
}