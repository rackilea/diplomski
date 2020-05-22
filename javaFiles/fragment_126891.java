boolean nimiOlemas = preferences.getBoolean("nimionolemas", false);
if (nimiOlemas == false)
{
     startActivity(new Intent("viimane.voimalus.NIMEKYSIJA"));
     finish();
     nimiOlemas = true;
}