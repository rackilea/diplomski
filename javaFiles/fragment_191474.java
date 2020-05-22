String sample="Give your club and/or district the publicity and recognition it deserves! Tell your local community about Toastmasters events, programs and member achievements. Use the news templates below to garner interest and awares are formatted and downloadable as Word documents.Click on a news release and save it to your computer. Localize the news release by replacing the bolded text with your club or district information. Proofread it for accuracy."
String selectedText = tarea.getSelectedText();
int lastIndex = 0;
int firstIndex = 0;
if (!null.equals(sample) && sample.contains(selectedText)) {
    lastIndex = sample.lastIndexof(selectedText) + selectedText.length;
    firstIndex = sample.lastIndexof(selectedText);
}