String line;
while ((line = reader.readLine()) != null) {
    if (line.startsWith("//") || line.trim().isEmpty())
        continue;
    else if(line.startsWith("start"))
        start= line.charAt(line.indexOf("{")+1);
    else if(line.startsWith("forward"))
        forward= line.charAt(line.indexOf("{")+1);
    else if(line.startsWith("end"))
        end= line.charAt(line.indexOf("{")+1);
    else if(line.startsWith("pause"))
        pause= line.charAt(line.indexOf("{")+1);
    else if(line.startsWith("path"))
        for(String s: line.substring(line.indexOf("{")+1, line.indexOf("}")).split(", "))
                path.add(s.charAt(0));