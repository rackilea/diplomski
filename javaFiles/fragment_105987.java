public static void main(String[] args) 
        { 
            try 
            {     
                File fXmlFile = new File(".xml");  
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
                Document doc = dBuilder.parse(fXmlFile);        
                doc.getDocumentElement().normalize();          
                NodeList nList = doc.getElementsByTagName("user");   

                System.out.println("============================================");
                System.out.println("==========Welcome to Multiuser ATM=========="); 
                System.out.println("============================================\n\n"); 
                System.out.println("Please enter your Account Number:"); 
                int acno = sc.nextInt();       
                System.out.println("Please enter your Password:");  
                int password = sc.nextInt();        
                System.out.println("Your Account Balance is:"); 
                System.out.println("Please choose your option:"); 

    //------------You just have to insert below code---------------------

                for (int temp = 0; temp < nList.getLength(); temp++)
                {
                    Node nNode =  nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element eElement = (Element) nNode;
                        int ano = Integer.parseInt(getTagValue("acno", eElement));
                        System.out.println("ANO:  "+ano);
                        if(ano == acno)
                        {
                            System.out.println("Acno:    "+acno+"  ANO:  "+ano);
                            int pass = Integer.parseInt(getTagValue("password", eElement));
                            if(pass == password)
                                System.out.println("Password:    "+password+"  pass:  "+pass);
                        }                   
                    }
                }
            }   
            catch (Exception e)  
            {
                e.printStackTrace(); 
            }