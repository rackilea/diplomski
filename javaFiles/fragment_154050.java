List listOfPersonNames = jListpersons.getSelectedValuesList();

// your list of strings
List<String> listOfNameStrings = new ArrayList<String>(listOfPersonNames.size());

for (Object personName: listOfPersonNames) {
    listOfNameStrings.add(personName.toString());
}

// your string from the resulting list
String listString = listOfNameStrings.toString();