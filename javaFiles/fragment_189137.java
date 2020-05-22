String data = "apple";
char[] charArray = data.toCharArray();
int total=0;
for(char ch : charArray){
   total+=characterMap.get(ch);
}
System.out.print("Total : "+total);