public static void main(String[] args) {
  String getErrText = ""; // <--------------- To trigger else.
  String readerIterator = "Yes it is"; // <-- To display a message.
  if (getErrText.length() > 0) { // <-------- else means that getErrText **must** be ""
    System.out.println(getErrText + " For "
        + readerIterator);
  } else {
    System.out.println("Error is not displayed "
        + "- Err Cell For " + readerIterator);
  }
}