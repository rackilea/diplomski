public static double[] arrayFromUrl(String url) throws Exception {
    Scanner fin = new Scanner((new URL(url)).openStream());
    fin.useLocale(Locale.US);
    int count = fin.nextInt();

    double[] dubs = new double[count];

    for ( int i=0; i<dubs.length; i++)
        dubs[i] = fin.nextDouble();
    fin.close();

    return dubs;
}