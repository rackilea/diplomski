Intent intent = getIntents();
String stringToDisplay = null;

if (intent != null) 
{
   stringToDisplay = intent.getStringExtra (EXTRA_STRING_CONTENT);
}