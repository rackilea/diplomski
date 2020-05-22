public static void main(String[] args){  
       int numInput;
       String inputString;
       Scanner scanner = new Scanner(System.in);
       numInput = scanner.nextInt();

       for(int y = 0; y < numInput;y++){           
           inputString = scanner.next();
           char[] chars = inputString.toCharArray();
           int counter = 0;

           char curr;
           for(int x = 0; x < chars.length;x++){
               curr = chars[x];
             if(x>0){
                if(chars[x-1] == curr){
                    counter++;
                }
             }
           }
           System.out.println("Count for string " + inputString + " was " + counter);
       }
       scanner.close();
   }