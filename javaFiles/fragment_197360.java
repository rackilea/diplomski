int result = 0;
int count = 0;
for(int i = 0; i < s.length(); i++){
    if(s.charAt(i) == c){
       result += Integer.min(k + 1, count);
       count++;
    } 
}