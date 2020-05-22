for (int i = 0; i < zombie.size(); i++) {
    Rectangle r1 = zombie.get(i).getBounds();
    for (int j = i+1; j < zombie.size(); j++) {
        if (r1.intersects(zombie.get(j).getBounds())) {
            // Code goes here
        }
    }
}