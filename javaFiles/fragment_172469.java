@Override
public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
    Language language = dataSnapshot.getValue(Language.class);
    languageR.insert(language);
    Log.d(TAG, language.getLangName());
}