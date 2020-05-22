public class PersonClassifierTrainer {

    static String modelFile = "/opt/NLP/data/en-ner-customperson.bin";

    public static void main(String[] args) throws IOException {

        InputStreamFactory isf = new InputStreamFactory() {
            public InputStream createInputStream() throws IOException {
                return new FileInputStream("/opt/NLP/data/person.train");
            }
        };

        Charset charset = Charset.forName("UTF-8");
        ObjectStream<String> lineStream = new PlainTextByLineStream(isf, charset);
        ObjectStream<NameSample> sampleStream = new NameSampleDataStream(lineStream);

        TokenNameFinderModel model;
        TokenNameFinderFactory nameFinderFactory = new TokenNameFinderFactory();

        try {
            model = NameFinderME.train("en", "person", sampleStream, TrainingParameters.defaultParams(),
                    nameFinderFactory);
        } finally {
            sampleStream.close();
        }

        BufferedOutputStream modelOut = null;

        try {
            modelOut = new BufferedOutputStream(new FileOutputStream(modelFile));
            model.serialize(modelOut);
        } finally {
            if (modelOut != null)
                modelOut.close();
        }
    }
}