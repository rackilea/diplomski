for (int i = 0; i < nodes.getLength(); i++) {
   if(i%5==0)
      System.out.println("Custom Message - your text");
   System.out.println(nodes.item(i).getFirstChild().getNodeValue());
   }
}