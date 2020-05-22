public class Test {
        public static String  returnWhatIsInTheArrayAsAString(char [][] a){
            String whatIs = " ";
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                   whatIs += a[i][j];
                }
                whatIs += "\n";
            }
            return whatIs + "\n";
        }

        public static void main(String[] args) throws Exception {
            char[][] foo = new char[][] {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}};
            System.out.println(returnWhatIsInTheArrayAsAString(foo));
        }
    }