int len = Math.max(listOLists.size(), Math.max(areaCode.size(), areaDescription.size()));
for(int i = 0; i < len; i++) {
    System.out.printf("%10s", (i < listOLists.size()) ? listOLists.get(i) : "");
    System.out.printf(" %10s", (i < areaCode.size()) ? areaCode.get(i) : "");
    System.out.printf(" %30s", (i < areaDescription.size()) ? areaDescription.get(i) : "");
    System.out.println();
}