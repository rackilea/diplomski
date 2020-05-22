public static void main(String[] args) 
throws IOException {
try {               File file = new File("D:\\TextFile.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            int lineNumber=0;
            Map<String,Integer> valueMap=new HashMap<String,Integer>();
            while ((line = bufferedReader.readLine()) != null&& ++lineNumber<4) {

             String[] sArr=line.split("=");
             //Here you have the number, do whatever you want with it.
             Integer iNumber=Integer.parseInt(sArr[1]);

             valueMap.put(sArr[0],iNumber);


            }


        String expression = bufferedReader.readLine();//Read 4th line, expression, delimited by space
        String[] sArr=input.split(" ");
        int operand1=valueMap.get(sArr[0]);
        int operand2=valueMap.get(sArr[2]);
        int operand3=valueMap.get(sArr[3]);

        char operator1=sArr[1].charAt(0);
        char operator2=sArr[1].charAt(0);
  // Now Calculate and output.
  fileReader.close();
} catch (IOException e) {
    e.printStackTrace();
}

}