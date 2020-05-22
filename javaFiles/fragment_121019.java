public int sort(Object ent1, Object ent2) {
    String s1 = (String) ent1;
    String s2 = (String) ent2;

    Collator collator = Collator.getInstance(new Locale("cs"));  //Your locale here
    collator.setStrength(Collator.IDENTICAL);
    return collator.compare(s1, s2);
}