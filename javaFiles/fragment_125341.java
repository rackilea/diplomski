Namespace namespace = Namespace.getNamespace("http://www.energystar.gov/manageBldgs/req");
Element root = new Element("ManageBuildingsRequest", namespace);
Namespace XSI = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
root.addNamespaceDeclaration(XSI);
root.setAttribute("schemaLocation", "http://www.energystar.gov/manageBldgs/req http://estar8.energystar.gov/ESES/ABS20/Schemas/ManageBuildingsRequest.xsd", XSI);

Element customer = new Element("customer", namespace);
root.addContent(customer);
doc.addContent(root); // doc jdom Document