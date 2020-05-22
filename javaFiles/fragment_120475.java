public static void main(String[] args){
            Read readFile = new Read(); 
            readFile.doSomething(args[0]);
            readFile.doSomething(args[1]);//You can read multiple files
            ....
        }
        public void doSomething (String inputFile) throws FileNotFoundException{
            File inputFile = new File (inputFile);
            //Read File With Scanner
        }