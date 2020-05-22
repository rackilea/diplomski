package combinations;

import java.util.ArrayList;

public class Combinations {

    static String[] combination = {"123","12","34"};

    public static void main(String[] args) {

        Combinations combinations = new Combinations();

        ArrayList<String> string = new ArrayList<String>();
        ArrayList<String> input = new ArrayList<String>();

        input = combinations.stringDecomposition(combination[0]);
        string = combinations.combinations(input,combination[1]);

        // next for loop starts from index i = 2 since result of combining first 2 elements
        // has just been calculated in the last line 

        for(int i = 2; i<combination.length; i++)
        {
            string = combinations.combinations(string,combination[i]);
        }

        for(int i = 0; i<string.size(); i++)
        {
            System.out.println(string.get(i));
        }

    }


        public ArrayList<String> combinations(ArrayList<String> input0, String input1){

            ArrayList<String> result = new ArrayList<String>();

                int jlength = input1.length();

                for(int i=0; i<input0.size(); i++)
                {

                        for(int j=0; j<jlength; j++)
                        {

                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(input0.get(i));
                            stringBuilder.append(input1.charAt(j));
                            result.add(stringBuilder.toString());   
                        }

                }

            return result;

        }

        public ArrayList<String> stringDecomposition(String in){

            ArrayList<String> result = new ArrayList<String>();

            for(int i =0;i<in.length();i++){
                StringBuilder s = new StringBuilder();
                s.append(in.charAt(i));
                result.add(s.toString());               
            }

            return result;

        }

}