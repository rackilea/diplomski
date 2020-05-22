public class ReverseString {

public String reverse(String input) {
    String new_string = "";
    int iterator = 0;
    int length = input.length();

        while(iterator < length){
            char string_input = input.charAt(iterator);
            new_string = string_input + new_string;
            iterator ++;
        }
    return new_string;
}



public static void main(String[] args){
    ReverseString test = new ReverseString();
    System.out.println(test.reverse("def"));
}
}