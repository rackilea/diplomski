String userCmd="\"C:\\Users\\Username\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe\""
        +" www.youtube.com";

List<String> list=new ArrayList<>();
list.add("cmd.exe");
list.add("/c");

Pattern p = Pattern.compile("\"[^\"]+\"|\\S+");
Matcher m = p.matcher(userCmd);
while (m.find()) {
    System.out.println("adding " + m.group());
    list.add(m.group());
}

ProcessBuilder pb = new ProcessBuilder(list);
Process pr = pb.start();

InputStream err=pr.getErrorStream();
BufferedReader errReader=new BufferedReader(new InputStreamReader(err));
String line=null;
while((line=errReader.readLine())!=null){
    System.out.println(line);
}