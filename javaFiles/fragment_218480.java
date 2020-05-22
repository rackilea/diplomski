void print_all(char []ch,int maxLen){
     for(int i=1;i<=maxLen;i++)
        backTrack(ch,i,0,new char[i]);
}
void backTrack(char[] ch,int len,int k,char[] ans){
    if(k==len){
        System.out.print(new String(ans,0,len)+",");
        return;
    }
    for(int i=0;i<ch.length;i++){
            ans[k]=ch[i];
            backTrack(ch,len,k+1,ans);
    }
}