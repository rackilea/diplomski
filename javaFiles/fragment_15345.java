public static void main(String[] args) {        
        generateXml();
    }
     private static void generateXml()  {
            XStream xStream = new XStream(new DomDriver());

            String line = null;
            try{
                BufferedReader br = new BufferedReader(new FileReader(new File("Unique Numbers.txt"))) ;

                while ((line = br.readLine()) != null) {
                    String xml = xStream.toXML(line);
                    System.out.println(xml);
                }
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }

            }