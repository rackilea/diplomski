String s = "\"Zanesville,OH\"        +39.93830        -82.00830      84ZC  PMNQ\n" + 
        "\"Zaragoza,Spain\"        +41.66670         -1.05000      GWC7  PXB0\n" + 
        "\"Zurich,Switzerland\"        +47.36670         +8.53330      HP9Z  QVT0\n" + 
        "\"Zwickau,Germany, United States\"        +50.70000        +12.50000      J17H  RFH0";
String[] tok = s.split("\\s+(?=(?:[^\"]*+\"[^\"]*+\")*+[^\"]*+$)");
System.out.println(Arrays.toString(tok));