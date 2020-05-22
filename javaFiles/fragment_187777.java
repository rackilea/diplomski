public class TestPassByReference {

    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder("Lets Test!");
        changeStringDoesNotWork(stringBuilder);
        System.out.println(stringBuilder.toString());
        changeString(stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    static void changeString(StringBuilder stringBuilder){
        stringBuilder.append(" Yeah I did it!");
    }

    static void changeStringDoesNotWork(StringBuilder stringBuilder){
        stringBuilder = new StringBuilder("This will not work!");
    }
}