if (selement.getNodeName().equals("Address"))
{
    String street = null;
    String city = null;
    String state = null;
    String zip = null;
    String phone = null;
    NodeList addressChildren = selement.getChildNodes();
    for(int k=0; k < addressChildren.getLength(); k++) {
        Node addrNode = addressChildren.item(k);
        if(addrNode.getNodeName().equals("Street")
        {
           street = addrNode.getTextContent();
        }
        ...//etc for City, State, Zip, and Phone
        Address a = new Address(street, city, state, zip, phone)
        obj.setAddress(a);
    }
}
if (selement.getNodeName().equals("Classes"))
{
    NodeList classNodes = selement.getChildNodes();
    Course[] courses = new Course[classNodes.getLength());
    for(int l=0; l < classNodes.getLength(); l++) {
        Node classNode = classNodes.item(l);
        NodeList classChildren = classNode.getChildNodes();
        for(int m=0; m < classChildren.getLenght(); m++)
        {
            Node classChild = classChildren.item(i);
            int crn = Integer.parseInt(classChild.getAttributes().getNamedItem("crn").getTextContent());
            String name = null;
            String units = null;
            if(classChild.getNodeName().equals("Name")
            {
               name = classChild.getTextContent();
            }
            if(classChild.getNodeName().equals("Units")
            {
               units = classChild.getTextContent();
            }
            courses[m] = new Course(crn, name, units);
        }
        obj.setCourses(Arrays.asList(courses));
    }
}