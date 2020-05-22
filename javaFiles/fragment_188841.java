String inputText;

String END_MARKER = "XXX123";

int indexOfEnd = inputText.indexOf(END_MARKER);
// search in reverse
int indexOfScenario = inputText.lastIndexOf("Scenario", indexOfEnd);

String result = inputText.substring(indexOfScenario, 
    indexOfEnd + END_MARKER.length());