Control kids[] = parent.getChildren();

if (kids != null && kids.length != 0) {
  getShell().setDefaultButton( (Button)kids[kids.length - 1] );

}