public class XmlToPojoTest {
    @Test
    public void testBasic() {
        String xmlString = "<employee>" +
                "    <department>" +
                "        <id>101</id>" +
                "        <name>IT-ABC</name>" +
                "    </department>" +
                "    <firstName>JJ</firstName>" +
                "    <id>1</id>" +
                "    <lastName>JoHo</lastName>" +
                "</employee>";
        XmlToPojo xmlToPojo = new XmlToPojo();
        Employee emp = (Employee) xmlToPojo.convertXmlToObject(xmlString, Employee.class);
        assertEquals("JJ", emp.getFirstName());
        assertEquals("IT-ABC", emp.getDepartment().getName());
    }
}