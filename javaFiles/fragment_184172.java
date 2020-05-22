import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LerEscreverArquivo{

    private static final String NomeArquivoEntrada = "matriculasSemDV.txt";
    private static final String NomeArquivoSaida = "matriculasComDV.txt";

    public static void main(String[] args) {

        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            // input file
            fr = new FileReader(NomeArquivoEntrada);
            br = new BufferedReader(fr);

            fw = new FileWriter(NomeArquivoSaida);
            bw = new BufferedWriter(fw);

            String sCurrentLine = "";
            System.out.println("Início do arquivo.");

            while ((sCurrentLine = br.readLine()) != null) {

                if (!sCurrentLine.isEmpty()) {

                    int Total = 0;
                    int contador = 5;
                    int resto;

                    for (int i = 0; i < sCurrentLine.length(); i++) {

                        int j = Character.digit(sCurrentLine.charAt(i), 10);

                        Total = Total + (j * contador);
                        contador = contador - 1;
                    }

                    resto = Total / 16;
                    String decimal = Integer.toHexString(resto);
                    String DigitoCod = sCurrentLine + "-" + decimal;

                    // output file
                    bw.write(DigitoCod);
                    System.out.println(DigitoCod);
                }
            }

            System.out.println("Fim do arquivo.");

        } catch (IOException eReader) {
            eReader.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException exeReader) {
                exeReader.printStackTrace();
            }
        }
    }
}