public static String getCharacterDataFromElement(Element e) {

    NodeList list = e.getChildNodes();
    String data;

    for(int index = 0; index < list.getLength(); index++){
        if(list.item(index) instanceof CharacterData){
            CharacterData child = (CharacterData) list.item(index);
            data = child.getData();

            if(data != null && data.trim().length() > 0)
                return child.getData();
        }
    }
    return "";
}