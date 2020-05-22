// set before generate XML
boolean isUpperCase;

// use function for each tag/attribute name instead of string constant
// smth. like getInCase("rootElement")
String getInCase(String initialName) {
    String intialFirstCharacter = initialName.substring(0, 1);
    String actualFirstCharacter;
    if (isUpperCase) {
        actualFirstCharacter = intialFirstCharacter.toUpperCase();
    } else {
        actualFirstCharacter = intialFirstCharacter.toLowerCase();
    }
    return actualFirstCharacter + initialName.substring(1);

}