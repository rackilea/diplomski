extractedMethod(1);
secondExtractedMethod(2);
secondExtractedMethod(3);
...
function extractedMethod(int i) {
    secondExtractedMethod(i);
}
function secondExtractedMethod(int i) {
    extractableCode(i);
}