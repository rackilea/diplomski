public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
    List<Employee> empList = null;
    Employee currEmp = null;

    XMLInputFactory factory = XMLInputFactory.newInstance();
    String currentDistID=null;

    InputStream inputStream= new FileInputStream("c:\\sample.xml");

    XMLStreamReader reader =
            factory.createXMLStreamReader(inputStream);

    while(reader.hasNext()){
        int event = reader.next();

        switch(event){
            case XMLStreamConstants.START_ELEMENT:
                if ("dist".equals(reader.getLocalName())){
                    //all subsequent employees share this.
                    currentDistID = reader.getAttributeValue(null, "id");
                }
                else if ("emp".equals(reader.getLocalName())){
                    currEmp = new Employee();
                    currEmp.id=currentDistID;
                    currEmp.name = reader.getAttributeValue(null, "name");
                    currEmp.age = reader.getAttributeValue(null, "age");
                    currEmp.location = reader.getAttributeValue(null, "location");
                }
                if("top".equals(reader.getLocalName())){
                    empList = new ArrayList<Employee>();
                }
                break;


            case XMLStreamConstants.END_ELEMENT:
                Cloumns value = Cloumns.valueOf(reader.getLocalName());
                switch(value){
                    case emp:
                        empList.add(currEmp);
                        break;

                }
                break;

            case XMLStreamConstants.START_DOCUMENT:
                //empList = new ArrayList<Employee>();
                break;
        }

    }

    //Print the employee list populated from XML
    for ( Employee emp : empList){
        System.out.println(emp);
    }

}