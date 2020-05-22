const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

// Draw the ellipse
ctx.beginPath();
ctx.lineWidth = 10;
ctx.ellipse(1000, 1000, 500, 800, Math.PI / 4, 0, 2 * Math.PI);
ctx.stroke();

// Draw the ellipse's line of reflection
ctx.beginPath();
ctx.setLineDash([5, 5]);
ctx.moveTo(0, 2000);
ctx.lineTo(2000, 0);
ctx.stroke();


canvas.addEventListener('click', function (e) {
  var dataURL = canvas.toDataURL('image/png');
  var link = document.createElement("a");
  link.download = "finalsize.png";
  link.href = dataURL;
  link.click();
});