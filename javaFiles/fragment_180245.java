// String[] names = "Grapes,Strawberries,Raspberries,Blackberries,Pineapples,Oranges,Prunes,Pears,Cherries,Peaches,Apples".split(",");
String[] names = "Pineapples,Oranges,Prunes,Pears,Cherries,Peaches,Apples".split(",");
int maxQuantity = 10;
long combinations = 1;
int quantities = maxQuantity + 1;
for (String _ : names)
    combinations *= quantities;

long start = System.currentTimeMillis();
PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("combinations.tsv")));
// heading
for (String name : names)
    out.print(name + "\t");
out.println();

for (long comb = 0; comb < combinations; comb++) {
    // comb is a base N number of digits 0 to maxQuantity.
    long c = comb;
    for (int i = 0; i < names.length; i++) {
        long n = c % quantities;
        c /= quantities;
        out.print(n);
        out.print('\t');
    }
    out.println();
}
out.close();
System.out.println("Took " + (System.currentTimeMillis() - start) / 1e3 + " seconds" +
        " to write " + combinations + " combinations");