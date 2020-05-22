StringBuilder b = new StringBuilder();// Or use StringBufer if you need synchronization
b.append("----------"); //use dash instead of space for visibility
int pos = 4; 

String replacement = "foo";
b.replace(pos, pos + replacement.length(), replacement); //Attention: if the length of the replacement is greater than the length of the original content, the exceeding chars will be appended
System.out.println(b); //----foo---