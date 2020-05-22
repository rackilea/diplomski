Graphics2D g2 = (Graphics2D) g;

// resetting the context state
g2.scale(0.5, 1.0);
g2.drawLine(5, 50, 100, 50);
g2.scale(2, 1.0);

// using a copy of the context
// note: casting is mandatory since 'create' returns a Graphics object
Graphics2D g2copy = (Graphics2D)g2.create(); 
g2copy.scale(1.0, 1.0);
g2copy.drawLine(5, 100, 100, 100);

// this one doesn't have any scale applied
g2.drawLine(5, 150, 100, 150);