public static int readLines(String[] career, int[] salary) throws Exception{

    int i = 0, j=0, count = 0;
    java.io.File careers = new java.io.File("Careers.txt");
    Scanner infile = new Scanner(careers);
    String line="";
    while(infile.hasNextLine()){    

        line=infile.nextLine(); 

        //check if you are reading the string's line or number's line
        if(line.trim().replaceAll("\\d","").length()!=0){ 
            career[j] = line;
            j++;
        }
        else{
            salary[i] = Integer.parseInt(line.trim());
            i++;
            count++;
        }   
    }
    infile.close();
    return count;
}