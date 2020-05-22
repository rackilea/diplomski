// sample data: a parent section containing nodes
String szHTML = "<section><banner><child>1</child></banner><abc></abc></section>";

Document doc = Jsoup.parse(szHTML);

// select the element section
Element sectionEle = doc.select("section").first();

// renaming the section element to mysection
sectionEle.tagName("mysection");

// get all the children elements of section element
Elements children = sectionEle.children();

// remove all the children
for(Node child: children){
    child.remove();
}

// insert element b in mysection
Element b = sectionEle.appendElement("b");

// insert all the child nodes back to element b
b.insertChildren(0, children);


System.out.println(doc.toString());