List<String> attributNames = new ArrayList<String>();
if(child.getAttributes() != null){
    for (int i = 0; i < child.getAttributes().getLength(); i++) {
        attributNames.add(child.getAttributes().item(i).getNodeName());
    }
}