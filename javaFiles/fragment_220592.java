RealmQuery<xPhrase> query = realm.where(xPhrase.class).contains("alala");
if (SOMETHING) {
    query.contains("asdfasdfdasf");
} else if (ANOTHERTHING) {
    query.contains("trampampam")
} else {
    query.contains("blablabla");
}
dpPhrases = query.findAll();