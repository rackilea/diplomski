String line; 
while (scanner.hasNextLine()) {
        // Get the line
        line = scanner.nextLine();

        // if line contains xxx then replace
        if (line.contains("j(ac)")) {  
            line = line.replaceAll("/.*?/", "/"+raw1+"/");

        } else if (line.contains("i(ac)")) {  
            line = line.replaceAll("/.*?/", "/"+raw2+"/");

        } else if (line.contains("k(ac)")) { 
            line = line.replaceAll("/.*?/", "/"+raw3+"/");

        }else if (line.contains("mp(k)")) {   
            line  = line.replaceAll("/.*?/", "/"+raw4+"/");

        }else if (line.contains("bp(k)")) {    
            line = line.replaceAll("/.*?/", "/"+raw5+"/");

        } 

        // Write the line with replaced items
        out.write(line);
        out.write("\n");
}