void paintSomething(Graphics2D g) {
    ...
    g.draw(someShape);

    // Everything that is painted after this line will
    // be painted 3 times as large: 
    g.scale(3.0, 3.0);

    g.draw(someShape); // Will be drawn larger 
}