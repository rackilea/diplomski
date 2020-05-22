Process p = null;
Runtime r = Runtime.getRuntime();
String OS = System.getProperty("os.name").toLowerCase();
// System.out.println(OS);
if (OS.indexOf("windows 9") > -1) {
  p = r.exec( "command.com /c set" );
}
else if ( (OS.indexOf("nt") > -1)
       || (OS.indexOf("windows 2000") > -1 )
       || (OS.indexOf("windows xp") > -1) ) {
  // thanks to JuanFran for the xp fix!
  p = r.exec( "cmd.exe /c set" );
}