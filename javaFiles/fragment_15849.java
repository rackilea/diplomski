import java.util.*;public class verses {

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int lines = input.nextInt();
    int[] arr = new int[lines];
    int vowels = 0;
    boolean vcheck = true;
    int vocheck = 0;
    for(int i = 0; i < lines; i++){
        arr[i] = input.nextInt();
    }
    input.nextLine();
    String[] word = new String[lines];
    for(int x = 0; x < word.length; x++){
        word[x] = input.nextLine();
    }
    //word[word.length-1] = input.nextLine();

    for(int m = 0; m < lines; m++){
        vocheck = 0;
        for(int y = 0; y < word[m].length(); y++){
            if(word[m].charAt(y) == 'a'
                    || word[m].charAt(y) == 'e'
                    || word[m].charAt(y) == 'i'
                    || word[m].charAt(y) == 'o'
                    || word[m].charAt(y) == 'u'
                    || word[m].charAt(y) == 'y'){
                vocheck++;
            }
        }
        if(vocheck != arr[m]){
            vcheck = false;
        }

    }
    if(vcheck == true){
        System.out.println("YES");
    }else{
        System.out.println("NO");
    }
}