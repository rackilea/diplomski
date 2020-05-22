String[] command = {"/usr/sbin/system_profiler"}
String sendback = "";    
Process proc = Runtime.getRuntime().exec(command);
InputStream istr = proc.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(istr));
String str;
while ((str = br.readLine()) != null) {
    sendback = sendback + str;
}
int resultCode = proc.waitFor();
br.close();
if (resultCode != 0) {
    throw new Exception("failed to open system profiler");
}