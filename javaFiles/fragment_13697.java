public class Example {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        Element rootElement = doc.createElement("Employees");
        doc.appendChild(rootElement);

        Element empInfoDept1 = doc.createElement("EmpInfo_Dept1");
        rootElement.appendChild(empInfoDept1);
        Element employee1 = createEmployeeElement(doc, "Luisha", "D111", "20000");
        empInfoDept1.appendChild(employee1);
        Element employee2 = createEmployeeElement(doc, "Lisha", "D112", "50000");
        empInfoDept1.appendChild(employee2);

        Element empInfoDept2 = doc.createElement("EmpInfo_Dept2");
        rootElement.appendChild(empInfoDept2);
        Element employee3 = createEmployeeElement(doc, "Jack", "D211", "20000");
        empInfoDept2.appendChild(employee3);
        Element employee4 = createEmployeeElement(doc, "Johnson", "D212", "50000");
        empInfoDept2.appendChild(employee4);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("file.xml"));
        transformer.transform(source, result);
    }

    public static Element createEmployeeElement(Document doc, String name, String id, String salary) {
        Element staff = doc.createElement("Employee");

        Attr nameAttr = doc.createAttribute("name");
        nameAttr.setValue(name);
        staff.setAttributeNode(nameAttr);

        Attr idAttr = doc.createAttribute("id");
        idAttr.setValue(id);
        staff.setAttributeNode(idAttr);

        Attr salaryAttr = doc.createAttribute("salary");
        salaryAttr.setValue(salary);
        staff.setAttributeNode(salaryAttr);
        return staff;
    }
}