mouseWheelState = Mouse.getEventDWheel();

if(Math.abs(mouseWheelState)<deadbandWidth)
{
  mouseWheelState = 0;
}
mouseWheelState /= 120;