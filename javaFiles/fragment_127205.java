public class DoStuff
{
        public static String createOutput(int k){
                String s = "";
                for(int i = 0; i < k; i++)
                        s += "\n" + (char)(i+65);
                return s;
        }
}