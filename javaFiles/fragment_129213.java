boolean checkAnagram(String st1, String st2)
{   int arr[]=new int[26];
    int l1=st1.length();
    int l2=st2.length();
    if(l1!=l2){
        return false;
    }
for(int i=0;i<l1;i++){
    arr[st1.charAt(i)-97]+=1;
    arr[st2.charAt(i)-97]-=1;
}
 for(int i=0;i<25;i++){
     if(arr[i]!=0) return false;
 }
    return true;
}