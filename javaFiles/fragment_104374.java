public static void writeFile(List<String> listOfData, long num1, long num2) 
   throws IOException {
   try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUT))) {          
        for (String str : listOfData) {
            // change made here
            if (Long.valueOf(str) >= num1 && Long.valueOf(str) <= num2) {
                bw.write(str);
                bw.newLine();
            }           
        }       
    }   
}