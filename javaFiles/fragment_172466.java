import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import opennlp.tools.parser.Parse;

/**
 *
 * @author mgiaconia
 */
public class ParseWriter {

  public static void main(String[] args) {
    String filePath = args[0];

    try (FileWriter outputFileWriter = new FileWriter(new File(args[0]))) {
      ///this string taken from the Parse's unit tests in the OpenNLP  source code
      Parse p1 = Parse.parseParse("(TOP  (S-CLF (NP-SBJ (PRP It)  )(VP (VBD was) "
          + " (NP-PRD (NP (DT the)  (NN trial)  )(PP (IN of) "
          + " (NP (NP (NN oleomargarine)  (NN heir)  )(NP (NNP Minot) "
          + " (PRN (-LRB- -LRB-) (NNP Mickey) "
          + " (-RRB- -RRB-) )(NNP Jelke)  )))(PP (IN for) "
          + " (NP (JJ compulsory)  (NN prostitution) "
          + " ))(PP-LOC (IN in)  (NP (NNP New)  (NNP York) "
          + " )))(SBAR (WHNP-1 (WDT that)  )(S (VP (VBD put) "
          + " (NP (DT the)  (NN spotlight)  )(PP (IN on)  (NP (DT the) "
          + " (JJ international)  (NN play-girl)  ))))))(. .)  ))");

      StringBuffer parseString = new StringBuffer();
      //pass this referece into the show method
      p1.show(parseString);
      outputFileWriter.write(parseString.toString());
      outputFileWriter.flush();

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}