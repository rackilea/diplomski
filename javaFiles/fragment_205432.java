public static void main(String[] args) {
    // TODO Auto-generated method stub
     String line = "";
        int count = 0;
        int countLineNumber=0; //to count line numbers 
        List<String> arrayList = new ArrayList();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Zoo.txt"));
            while (line != null) {
                count++;
                line = br.readLine();
                if (line == null)
                    break;
                if (count == 3 || count % 3 == 1 && !line.equals("1") && 
         !line.equals("5") && !line.equals("10"));
                    arrayList.add(line);
                countLineNumber++;
            }
            //System.out.println(countLineNumber);

            br.close();

            } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }catch (IOException e) {
            System.err.println("Cannot read this file.");
        }

        //getting elements from arayList saving them into a array 
        String[] array=new String[countLineNumber];
        for(int i=0;i<countLineNumber;i++){
            array[i]=arrayList.get(i);
        }

        //display element in array
        for(int k=0;k<array.length;k++){
        System.out.println(array[k]);

        }
}