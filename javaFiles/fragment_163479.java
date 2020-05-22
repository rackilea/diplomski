for (int i = 0; i < nodeList.getLength(); i++) 
{
    Element e = (Element) nodeList.item(i);
    Employee employee = new Employee();
    employee.setId(Integer.parseInt(e.getAttribute(ATTR_ID)));
    employee.setName(e.getAttribute(NAME)));
    ...
}