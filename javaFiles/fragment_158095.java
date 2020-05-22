Validate.isTrue(word.length % 4 == 0, "Array size must be a multiple of 4");
List<Writer> writers = new ArrayList<>();
for (int i=0; i<word.length; i+=4) {
    String name = word[i];
    String lastname = word[i+1];
    String dod =word[i+2];
    String cob= word[i+3];
    writers.add(new Writer(name, lastname, dod, cob));
}