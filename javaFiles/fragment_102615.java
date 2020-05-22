String main_str <--- MAIN STRING
String sub_str <--- SUB STRING
int n=0;
for(int i=0; i<sub_str.length();i++){        
    if(main_str.indexOf(sub_str.charAt(i))!=-1) 
    n++;
}
if(n==sub_str.length()) 
System.out.println("All elements of sub string EXIST in the main string");
else
System.out.println("All elements of sub string DO NOT EXIST in the main string");