//save the canvas transformation state
canvas.save();
   //first move the whole doll
   canvas.translate(dollPosition.x,dollposition.y);
   //we are now inside the coordinate system of the doll
   //draw head (Position is now relative to the center of the doll position)
   canvas.drawCircle(dollHeadPosition.x, dollHeadPosition.y, headRadius, paint);
   //save the canvas to transform leg independently
   canvas.save();
      canvas.translate(legPosition.x,legPosition.y);
      //draw leg
      canvas.drawRect(...);
      //restore the canvas to get back to your doll coordinate system
   canvas.restore()
//restore canvas to get to global coordinate system
canvas.restore()