try {

}
catch (ExceptionTypeA e1) { }
catch (ExceptionTypeB e2) { }


  try {
      bim=ImageIO.read(new File(....));
      int[] a={2, 2, 3,4 };
      a[7]=4;
  }
  catch (ArrayIndexOutOfBoundsException ex2) { System.err.println("error 2 "+ex2); }
  catch (Exception ex) { System.err.println("error 1 "+ex); }