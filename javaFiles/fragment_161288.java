if(credentialMatches)
                            SharedPreferences sharedPref = getSharedPreferences(
                                    "Save", 0);
                            SharedPreferences.Editor prefEditor = sharedPref
                                    .edit();
                            prefEditor.putBoolean("userLoggedBefore", true);
                            prefEditor.commit();
else{ // if credentials doesn't match
                           SharedPreferences sharedPref = getSharedPreferences("Save", 0);
                            SharedPreferences.Editor prefEditor = sharedPref
                                    .edit();
                            prefEditor.putBoolean("userLoggedBefore", false);
                            prefEditor.commit();
}