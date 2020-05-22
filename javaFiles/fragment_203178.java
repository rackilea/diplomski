boolean lastWasText = false;
int paragraphCount = 0;
while (file.hasNextLine()) {
  boolean thisIsText = file.nextLine().length() > 0;
  if (!lastWasText && thisIsText) paragraphCount++;
  count++;
  lastWasText = thisIsText;
}