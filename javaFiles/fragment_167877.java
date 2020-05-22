public class ClassifyTest {
    @Test
    public void trainAndTestBio() {
        Classify.main(new String[] {
            "-mode",       "train",
            "-algorithm",  "majority",
            "-model_file", "outputModelEvenOdd",
            "-data",       "./Homework1Data/bio/bio.train"
        });
        Classify.main(new String[] {
            "-mode",             "test",
            "-model_file",       "outputModelEvenOdd",
            "-data",             "./Homework1Data/bio/bio.dev",
            "-predictions_file", "bioPredictionsEvenOdd"
        });
    }
    @Test
    public void trainAndTestFinance() {
        // code here
    }
}