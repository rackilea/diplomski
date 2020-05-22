while (scanner.hasNextLine()) {
            // get the line (very first line) and store that in "line"
            String line = scanner.nextLine();

            // check if line contains "j(ac)"
            if (line.contains("j(ac)")) { 

            // if "line" contains replace everything and save it to "newline" 
                String newline = line.replaceAll("/.*?/", "/"+raw1+"/");

            // get next line getting used for nothing (second line stored nowhere)
                scanner.nextLine();

            // write the newline to output file.
                out.write(newline);
                out.write("\n");
            } 


            // some more if else blocks executing same patterns explained above


             else{ 
            // if nothing contains in "line" then write to output file
                out.write(line);
                out.write("\n");
            }
      }