Collator germanCollator = Collator.getInstance(Locale.GERMAN);
int[] strengths = new int[] {Collator.PRIMARY, Collator.SECONDARY,
                             Collator.TERTIARY, Collator.IDENTICAL};

String a = "ß";
String b = "ß".toUpperCase();

for (int strength : strengths) {
    germanCollator.setStrength(strength);
    if (germanCollator.compare(a, b) == 0) {
        System.out.println(String.format(
                "%s and %s are equivalent when comparing differences with "
                + "strength %s using the GERMAN locale.",
                a, b, String.valueOf(strength)));
    }
}