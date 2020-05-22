private void parseXML(XmlPullParser parser) throws XmlPullParserException,IOException
{
    ArrayList<Animal> animals = new ArrayList<Animal>();
    int eventType = parser.getEventType();
    Animal currentAnimal = null;


    while (eventType != XmlPullParser.END_DOCUMENT)
    {

        String name = null;
        switch (eventType)
        {
            case XmlPullParser.START_DOCUMENT:
                //animals = new ArrayList();
                break;
            case XmlPullParser.START_TAG:
                name = parser.getName();
                if (name.equalsIgnoreCase( "animal"))
                {
                    currentAnimal = new Animal();
                } 
                else if (currentAnimal != null)
                {
                    if (name.equalsIgnoreCase( "specificLocation"))
                    {
                        currentAnimal.specificLocation = parser.nextText();
                    } 
                    else if (name .equalsIgnoreCase( "name")){
                        currentAnimal.name = parser.nextText();
                    } 
                    else if (name .equalsIgnoreCase( "location"))
                    {
                        currentAnimal.location= parser.nextText();
                    }  
                    else if (name .equalsIgnoreCase( "image"))
                    {
                        currentAnimal.image= parser.nextText();
                    }  
                    else if (name .equalsIgnoreCase(  "animalInfo"))
                    {
                        currentAnimal.animalInfo= parser.nextText();
                    }  
                    else if (name .equalsIgnoreCase(  "todaysFeed"))
                    {
                        currentAnimal.todaysFeed= parser.nextText();
                    }  
                }
                break;
            case XmlPullParser.END_TAG:
                name = parser.getName();
                if (name.equalsIgnoreCase("animal") && currentAnimal != null){
                    animals.add(currentAnimal);
                } 
        }
        eventType = parser.next();
    }

    printAnimals(animals);
}