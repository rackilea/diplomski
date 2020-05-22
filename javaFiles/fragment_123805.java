String[] separated=new String[]{"some text ","1","some more text"};
int logSetting = 0;
  for(String i:separated){
     try {
        logSetting = Integer.parseInt(i);
      }catch (NumberFormatException e){
        System.out.println("NumberFormatException \""+i+"\" is not a number");
      }
     }
  System.out.println(logSetting);