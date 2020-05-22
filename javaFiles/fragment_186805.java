public void paint(Graphics g) {
    for (y = 0; y < GameObjectsArray.length; y++) {
        GameObject NewSquare = new GameObject();
        if (GameObjectsArray[y] == null) {
            GameObjectsArray[y] = NewSquare;
            NewSquare.paint(g);
        }
    }
}