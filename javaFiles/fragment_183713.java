switch (facing) {
  case North  : facing=rotateIt==Rotate.Clockwise?Face.East:Face.West; break;
  case West   : facing=rotateIt==Rotate.Clockwise?Face.North:Face.South; break;
  case East   : facing=rotateIt==Rotate.Clockwise?Face.South:Face.North; break;
  case South  : facing=rotateIt==Rotate.Clockwise?Face.West:Face.East; break;
}