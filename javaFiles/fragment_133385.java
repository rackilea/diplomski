// find root
NodeList rootList = doc.getElementsByName("Employees");
Node root = rootList.item(0);

// append using a helper method
root.appendChild(createEmployee(doc, "male", "John", "Doe"));

public Element createEmployee(Document doc,
                              String gender, String fname, String lname) {
  // create new Employee
  Element employee = doc.createElement("Employee");
  employee.setAttribute("gender", gender);

  // create child nodes
  Element firstName = doc.createElement("FirstName");
  firstName.appendChild(doc.createTextNode(fname));

  Element lastName = doc.createElement("LastName");
  lastName.appendChild(doc.createTextNode(lname));

  // append and return
  employee.appendChild(firstName);
  employee.appendChild(lastName);

  return employee;
}