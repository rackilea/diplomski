void generateAllStrings(int len, int K, String str) {
    if(len == 0) {
        // base case
        // push string str to arrayList or use anywhere
        return;
    }

    if(K > 0) {
        generateAllStrings(len - 1, K - 1, str + '2'); // as we have positive number
                                                       // of 2 in hand, let's use one
    }

    if(len > K) {
        // len > K so we can place a 1 here if we want
        generateAllStrings(len - 1, K, str + '1'); // note K is not decreased here
    }
}