System.out.println("length:"+addrAll.getLength());      
for(int tmp=0; tmp<addrAll.getLength();tmp+=2){
    String country = addrAll.item(tmp).getTextContent();
    String city = addrAll.item(tmp+1).getTextContent();
    System.out.printf("%s %s\n", country, city);
}