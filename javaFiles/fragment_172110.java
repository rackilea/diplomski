System.out.println(compare("abc", "ÀBC", Collator.PRIMARY)); //base char
System.out.println(compare("abc", "ÀBC", Collator.SECONDARY)); //base char + accent
System.out.println(compare("abc", "ÀBC", Collator.TERTIARY)); //base char + accent + case
System.out.println(compare("abc", "ÀBC", Collator.IDENTICAL)); //base char + accent + case + bits

private static int compare(String first, String second, int strength) {
   Collator collator = Collator.getInstance();
   collator.setStrength(strength);
   return collator.compare(first, second);
}