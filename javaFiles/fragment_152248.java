String line;
String pidInfo ="";

Process p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");

BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));

while ((line = input.readLine()) != null) {
    pidInfo+=line; 
}

input.close();

if(pidInfo.contains("your process name"))
{
    // do what you want
}