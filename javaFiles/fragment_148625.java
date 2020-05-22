public void init( int boxID ) {
  initComponentText();

  if ((boxID & ID_IMAGE) == ID_IMAGE) initComponentImg();
  if ((boxID & ID_BOOL) == ID_BOOL) initComponentBool();
}