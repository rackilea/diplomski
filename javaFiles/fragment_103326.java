Element bo = testDoc.createElement("bo");
bo.setAttribute("type", "Employee");
bo.setAttribute("id", emp.getId());
//create a username element
Element username = testDoc.createElement("username");
//add a text value to the username element
username.appendChild(testDoc.createTextNode("marv"));
//add the username element as child of bo element
bo.appendChild(username);