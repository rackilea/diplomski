public class SwitchBug { 

    static String hold(String item) { 
        return switch(item) { 
            case String s -> { System.out.println(s); } 
            default -> "temp"; 
        }; 
    } 

    public static void main(String[] args) { 
        System.out.println(hold("bug")); 
    } 
}