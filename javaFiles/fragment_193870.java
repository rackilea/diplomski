public enum ChemicalElement {
    F, Fe, Zn, K, Pb, Umm, //and so on...
}

public List<ChemicalElement> separateElements(String input) {
    String[] inputParts = input.split("(?=[A-Z]{1,1}[a-z]{0,2})");

    List<ChemicalElement> elementList = new LinkedList<ChemicalElement>();
    for (int i = 1; i < inputParts.length; i++) {
        String inputPart = inputParts[i];

        // note: throws IllegalArgumentException for unknown elements
        ChemicalElement element = ChemicalElement.valueOf(inputPart);
        if (null != element) {
            elementList.add(element);
        }

    }
    return elementList;
}