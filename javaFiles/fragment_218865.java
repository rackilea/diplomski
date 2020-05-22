public class AnotherExercise {

    public static void main (String[] args){

        String[] intruments = {"cello", "guitar", "violin", "double bass"};
        String[] intruments2 = new String[5];
        String nothing = "";

        for (int i = 0; i < 4; i++){

            intruments2[i] = intruments[i].replaceAll("a|e|i|o|u", nothing);

            System.out.println(intruments2[i]);
        }

    }

}