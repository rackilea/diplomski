String Name = "AStringExample";
  String Style = "TheStyle";
  Object[] argv = {7,9};
  Object[] argc = {Name,Style};
  Object[] NewArray = func_get_args(argv,Name,Style,argc);
  for (int i = 0; i < NewArray.length;i++) {
    System.out.println("i="+i+" -> "+NewArray[i].toString());
  }