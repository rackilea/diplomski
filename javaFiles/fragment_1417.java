Set<String> uniqueTokens = new LinkedHashSet<String>(Arrays.asList(mspace));
for (String k : uniqueTokens) {
    int freq = 0;
    for (int x = 0; x < nTokenSpace; x++) {
        if (k.equals(mspace[x])) {
            freq++;
        }
    }
    System.out.println(k + "\t" + freq);
}