for (XWPFParagraph paragraph: paragraphList)
{     
  if(kop.equals(paragraph.getStyle()))
  { 
    System.out.println("aantal keer door document :" +" " + aantal++);
    System.out.println(paragraph.getText());
  }
  else
  {
    System.out.println("Test");
  }