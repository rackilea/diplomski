// get attribute of thumbnail Tag
//get thumbnail ppicture link 
if(localPart.equals("thumbnail")){
    Iterator<Attribute> attribue = event.asStartElement().getAttributes();
    while(attribue.hasNext()){
        Attribute myAttribute = attribue.next();
        if(myAttribute.getName().toString().equals("url")){
            thumbnail = myAttribute.getValue();
        }
    }
}