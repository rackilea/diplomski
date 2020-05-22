for (int i = beginIndex; i < doNotPrintIndex; i++) {
     System.out.println(strArray.get(i));
}

for (int i = doNotPrintIndex + 1; i < strArray.size(); i++) {
     System.out.println(strArray.get(i));
}