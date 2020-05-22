...
// ls -al command lists the files and the alias
proc = Runtime.getRuntime().exec("ls -al /Volumes");

BufferedReader stdInput = new BufferedReader(new 
InputStreamReader(proc.getInputStream()));

String line;
// match the name between the time and the arrow
Pattern myPatter = Pattern.compile("[0-9]+:[0-9]+ (.*?) -> " + "/");
Matcher matcher;
while ((line = stdInput.readLine()) != null) {
        if (line.indexOf(" -> ") != -1){
            // get the real volume name                    
            matcher = myPatter.matcher(line);
            if (matcher.find())
                return matcher.group(1);                     
        }                    
}
...