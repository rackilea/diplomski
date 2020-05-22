private void getData(Document document){
    if(document == null)
        return;

    NodeList list = document.getElementsByTagName("photo");
    Element photoElement = null;

    if(list.getLength() > 0){
        photoElement = (Element) list.item(0);
    }

    if(photoElement != null){
        System.out.println("ID: "+photoElement.getAttribute("id"));
        System.out.println("Owner: "+photoElement.getAttribute("owner"));

        NamedNodeMap childList = photoElement.getAttributes();
        Attr attribute;

        for(int index = 0; index < childList.getLength(); index++){
            if(childList.item(index).getNodeType() == Node.ATTRIBUTE_NODE){
                attribute = ((Attr)childList.item(index));
                System.out.println(attribute.getNodeName()+" : "+attribute.getNodeValue());
            }else{
                System.out.println(childList.item(index).getNodeType());
            }
        }
    }
}