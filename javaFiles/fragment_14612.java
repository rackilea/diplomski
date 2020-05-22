public void moveAllAndRepaint(Person[][] universo, JPanel panel) {

    // call move on all Person objects in the universo
    for(int j = 0; j < universo.length; j++) {
        for(int i = 0; i < universo[j].length; i++) {
            if(universo[i][j] != null) {
                universo[i][j].move();
            }
        }
    }

    // redraws everything in the panel to reflect changes in the
    // Person objects
    panel.repaint();
}