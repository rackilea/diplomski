String[] parts = list.split("-");
RDFNode[] elements = new RDFNode[parts.length];

for(int i = 0; i<parts.length; i++){
    elements[i] = model.getOntClass("http://example.org/"+parts[i]);  
}

RDFList list = model.createList(elements);