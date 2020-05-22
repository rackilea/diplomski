List<String> myNames = new ArrayList<String>();
myNames.add("ani");
myNames.add("raj");
myNames.add("rob");
myNames.add("jigar");

int counter=1;
for(String str:myNames){
System.out.println(str.charAt(0)+String.format("%04d", i));
counter++;
}