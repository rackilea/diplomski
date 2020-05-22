public static void main(String[] args) {
    String s = "TejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejasTejas";

    int sLen = s.length();
    System.out.println("sLen=" + sLen);

    int maxPartLength = 153;

    int partsTotal = (int) Math.ceil(sLen/(double)maxPartLength);
    System.out.println("partsTotal=" + partsTotal);

    String[] parts = new String[partsTotal];
    for (int p = 0; p < partsTotal; p++) {
        int strIndex = maxPartLength*p;
        int endIndex = strIndex + maxPartLength;
        endIndex = endIndex > sLen ? sLen : endIndex;
        parts[p] = s.substring(strIndex, endIndex);
        System.out.println("part=" + parts[p]);
    }
}