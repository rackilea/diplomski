...
for (Cell c : r.getC() ) {
 if (c.getT().equals(STCellType.S)) {
  System.out.println( "  " + c.getR() + " contains " + sharedStrings.getJaxbElement().getSi().get(Integer.parseInt(c.getV())).getT() );
 } else {
  // TODO: handle other cell types
  System.out.println( "  " + c.getR() + " contains " + c.getV() );
 }
}
...