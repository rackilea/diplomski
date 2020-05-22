String s1="hello world";
char ch= 'o';
int a=0; 

for(int i=0;i<s1.length();i++){
    if(s1.charAt(i)==ch){
        a++;
    }
}

System.out.println(""+a);