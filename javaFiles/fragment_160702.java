Rectangle scissors = new Rectangle();
Rectangle clipBounds = new Rectangle(x,y,w,h);
ScissorStack.calculateScissors(camera, spriteBatch.getTransformMatrix(), clipBounds, scissors);
ScissorStack.pushScissors(scissors);
spriteBatch.draw(...);
spriteBatch.flush();
ScissorStack.popScissors();