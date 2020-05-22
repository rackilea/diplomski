Process pcs = Runtime.getRuntime().exec(
 "cmd /c start cacls E:\\PJ\\testing2.txt /e /p %username% : f");

 //Logic that manipulates the file here

 Process pcs = Runtime.getRuntime().exec(
 "cmd /c start cacls E:\\PJ\\testing2.txt /e /d %username%");