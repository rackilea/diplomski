ArrayList<String> elements = new ArrayList<String>();
Scanner scanner = new Scanner(html);

public String populateDivContents(String buildingString) {

    while(scanner.hasNext()) {

        //Get the next token
        String next = scanner.next();

        //If it's a <div>, call recursively
        if(next.equalsIgnoreCase("<div>")) {
            buildingString = buildingString + populateDivContents(next);
        }

        //If we've hit a closing tag, add our built String to the elements
        else if(next.equalsIgnoreCase("</div>") {
            buildingString = buildingString + next;
            elements.add(buildingString);
            return buildingString;
        }

        //Otherwise, simply add the text to our String and keep going
        else {
            buildingString = buildingString + next;
        }
    }
}