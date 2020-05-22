int noOfObj = 5;
    //create an array to hold elements
    Element[] elememtsArray = new Element[noOfObj];

    for(int i = 1; i<=noOfObj ; i++){

        Element element = doc.createElement("include");
        elememtsArray[i] = element;
    }