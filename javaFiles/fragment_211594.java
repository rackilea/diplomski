import java.io.*;

public class TestC {

    public static void main(String[] args) {
        int i = 0, j = 0;
        double result, values[] = new double[4];
        char k, operatorsAndOperands[] = new char[3];
        for (i = 0; i <= 2; i++)
            operatorsAndOperands[i] = '+'; // default is to add the values

        File myfile;
        StreamTokenizer tok;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String InputText;

        i = 0;
        try {
            myfile = new File("C:\\VarValPairs.txt");
            tok = new StreamTokenizer(new FileReader(myfile));
            tok.eolIsSignificant(false);

            while ((tok.nextToken() != StreamTokenizer.TT_EOF) && (i <= 3)) {
                if ((tok.ttype == StreamTokenizer.TT_NUMBER))
                    values[i++] = tok.nval;
            }
            for (int l = 0; l < values.length; l++) {
                System.out.println(values[l]);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return;
        } catch (IOException f) {
            System.out.println(f);
            return;
        }

        System.out.println("Enter letters and operators:");

        try {
            InputText = in.readLine().toUpperCase();
        } catch (IOException f) {
            System.out.println(f);
            return;
        }

        if(InputText.length() > 0){
            operatorsAndOperands = new char[InputText.length()];
        } else {
            System.out.println("No Operations specified");
            return;
        }
        for (i = 0; i < InputText.length(); i++) {
            k = InputText.charAt(i);
            operatorsAndOperands[j++] = k;
        }

        result = 0; 
        for (i = 0; i < operatorsAndOperands.length; i++) {
            System.out.println(operatorsAndOperands[i] + " " + (int)operatorsAndOperands[i]);
            if(i+1<operatorsAndOperands.length)
                System.out.println(operatorsAndOperands[i+1]);
            switch(operatorsAndOperands[i]){
            case '+':
                if(operatorsAndOperands[i+1] != '+' && operatorsAndOperands[i+1] != '-'){
                    result+=values[(int)operatorsAndOperands[i+1] - (int)'A'];
                    i++;
                }
                break;
            case '-':
                if(operatorsAndOperands[i+1] != '+' && operatorsAndOperands[i+1] != '-'){
                    result-=values[(int)operatorsAndOperands[i+1] - (int)'A'];
                    i++;
                }
                break;
            default:
                result = values[(int)operatorsAndOperands[i] - (int)'A'];
                break;
            };
            System.out.println(result);
        }
        System.out.println(result);
    }
}