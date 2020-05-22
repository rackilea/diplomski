if(str[1] != null) {
    Double eanCodeDouble = Double.parseDouble(str[1]);
    NumberFormat nf = NumberFormat.getInstance();
    String eanCodeString = nf.format(eanCodeDouble);
    System.out.println(resultedString);
} else {
    String eanCodeString = '';
}

if(str[0] == null) {
   str[0] = '';
}
    arrayList_stock2.add(new MasterDataModel2(str[0].trim(), eanCodeString));