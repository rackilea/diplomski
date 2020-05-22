ctx.fillStyle = "lightgray";

ctx.moveTo(0, 100);
ctx.quadraticCurveTo(50, 50, 50, 0);
ctx.quadraticCurveTo(50, 50, 100, 100);
ctx.lineTo(0, 100);
ctx.fill();
ctx.stroke();