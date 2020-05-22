Point org = new Point(64, 32); // Center.
Point radii = new Point(32, 16); // Half the size.

Point mousePos = ...

mousePos -= org; // Relative to the center.
boolean inside = Math.abs(mousePos.x) * radii.y + Math.abs(mousePos.y) * radii.x
                 <= radii.x * radii.y;