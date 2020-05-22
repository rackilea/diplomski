// Define the path
ctx.beginPath();
ctx.lineTo(..., ...);
ctx.lineTo(..., ...);
...
ctx.closePath();

// Stroke the path
ctx.setStrokeStyle("#...");
ctx.stroke();

// Fill the path
final CanvasGradient gradient = ctx.createLinearGradient(...);
gradient.addColorStop(0., "#...");
gradient.addColorStop(1., "#...");
ctx.setFillStyle(gradient);
ctx.fill();