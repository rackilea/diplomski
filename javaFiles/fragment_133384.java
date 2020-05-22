// find root
NodeList rootList = doc.getElementsByName("Employees");
Node root = rootList.item(0);

Element employee = doc.createElement("employee"); //create new Element
root.appendChild(employee); // append as before