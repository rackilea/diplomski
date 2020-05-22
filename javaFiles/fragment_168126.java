String nucList = CCATT-AATGATCA-CAGTT
int[] counter = new int[5];
for (int i = 0; i < nucList.length(); i++) {
    if (nucList.charAt(i) == 'A') {
        counter[0]++;
    } else if (nucList.charAt(i) == 'C') {
        counter[1]++;
    } else if (nucList.charAt(i) == 'G') {
        counter[2]++;
    } else if (nucList.charAt(i) == 'T') {
        counter[3]++;
    } else if (nucList.charAt(i) == '-') {
        counter[4]++;
    }
int[] counterNucs = Arrays.copyOfRange(counter, 0,  4);
filePrint.println("Nuc. Counts: " + Arrays.toString(counterNucs));