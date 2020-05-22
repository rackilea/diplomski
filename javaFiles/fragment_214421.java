public class Demo {

    public static boolean contains(String str,char c){
        //todo:check str for NullPointExecption
        int flag=0;
        for(int i=0;i<str.length();i++){
            if(c==str.charAt(i)){
                flag++; //if str contains char c,flag=flag+1
            }
            if(flag>=2){
                return true; //if flag>=2,return true
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(contains("appple", 'p'));//result is true
    }
}