public class Demo {

    public static void main(String[] args){

        int[] count= new int[26]; // 26 elements for 26 letters
        char[] inputs = {'a','b','a','b','c','a'}; // example input

        for(Character c : inputs){
            count[c-'a'] ++; 
           // if c='b', then c-'a' returns 1, thus increments the count[1].
        }

        for (int i=0; i<26; i++){
            // using if condition I only print the previously encountered letters
            if(count[i]>0)
                System.out.println((char)(i+'a')+":"+count[i]);
        }
    }

}