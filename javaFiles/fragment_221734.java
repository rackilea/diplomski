canvas.addMouseMoveHandler() - 
//if drag started through event 1 then - 
//get x & y;
//calculate centre of circle and radius based on startx, starty and x & y above
//Clear the canvas
//And add the following code

context.setFillStyle(color);
context.beginPath();
context.arc(calculatedCenterx, calculatedCentery, radius, 0, Math.PI * 2.0, true);
context.closePath();
context.fill();