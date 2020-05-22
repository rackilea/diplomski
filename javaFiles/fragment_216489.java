// select container div element
Elements position = doc.select("#content > table:nth-child(4) > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td > div:nth-child(5)");
// extract the element from the list returned
Element element = ....
// TODO will need to check that the List exists and have at least four elements here
TextNode ofNode = element.textNodes().get(4);
ofNode.text(); // this will contain "OF"