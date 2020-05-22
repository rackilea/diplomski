switch (text) {
  case "English":
    translatedText = Translate.execute(text1, Language.AUTO_DETECT, Language.ENGLISH); // location of Unhandled exception
    outputLanguageLabel.setText("English");
    Log.e("Checkpoint", "The program should work perfectly if this appears.");

    // Need to add break; after case
    break;

    ...

  default:
    Log.e("Checkpoint", "Program didn't recognize text.");
}