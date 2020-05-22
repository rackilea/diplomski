public class MyLibrary {

    public static class MyRecord{
        int number;
        char letter;

        public MyRecord(){
            number = 0;
            letter = '\0';
        }

        public MyRecord(int number, char letter){
            this.number = number;
            this.letter = letter;
        }
    }

    public static int TriplePlusThree(int input_number){ 
        return (input_number * 3 + 3);
    }
}