<cfscript>
  str = ":>exec ls -al";
  exec_init=str.split(":>exec ");
  exec=exec_init[2].split(" ");
  p = createObject("java","java.lang.ProcessBuilder").init(exec).start();
  i = createObject("java","java.io.InputStreamReader").init(p.getInputStream());
  br = createObject("java","java.io.BufferedReader").init(i);
  line = br.readLine();
  while (isDefined("line")) {
   writeoutput(line);
   line = br.readLine();
  }
  br.close();
  i.close();
</cfscript>