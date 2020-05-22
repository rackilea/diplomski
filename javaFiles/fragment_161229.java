public class QuestionSaver {

    /**
     * Public constructor for the QuestionSaver
     * 
     * @param question the question to be saved
     * @throws ParserConfigurationException
     */
    public QuestionSaver(){

    }

    public void saveQuestion(Question question) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // create the quiz root element
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("question");
        doc.appendChild(rootElement);

        save(rootElement, doc, question);
    }

    /**
     * General method for saving the question to the xml file
     */
    private void save(Element rootElement, Document doc, Question question) {
        /* first, save the question type independent properties */
        SaveIndependentProperties(rootElement, doc, question);

        /* Save the generated Document to an XML file */
        try {
            SaveToFile(doc);
        } catch (TransformerConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Saves the created document to an XML file
     * 
     * @throws TransformerConfigurationException
     */
    private void SaveToFile(Document doc) throws TransformerConfigurationException {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            // StreamResult result = new StreamResult(new File("C:\\file.xml"));

            // Output to console for testing
            StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);
        } catch (TransformerException e) {
            System.out.println("Fout met transformen!");
        }

        System.out.println("File saved!");

    }

    /**
     * Saves the properties of a question, which are independent from the questiontype
     * 
     * @param rootElement
     */
    private void SaveIndependentProperties(Element rootElement, Document doc, Question question) {
        /* add the actual question */
        Element actualquestion = doc.createElement("actualquestion");
        actualquestion.appendChild(doc.createTextNode(question.getQuestion()));
        rootElement.appendChild(actualquestion);

        /* add the score */
        Element score = doc.createElement("score");
        score.appendChild(doc.createTextNode(Integer.toString(question.getScore())));
        rootElement.appendChild(score);

        /* add the type */
        QuestionType questionType = question.getType();
        Element type = doc.createElement("type");
        type.appendChild(doc.createTextNode(getQuestionTypeString(questionType)));
        rootElement.appendChild(type);

        /* add the source */
        Element source = doc.createElement("source");
        source.appendChild(doc.createTextNode(question.getSource()));
        rootElement.appendChild(source);

        /* add the extra information */
        Element extraInformation = doc.createElement("extrainformation");
        extraInformation.appendChild(doc.createTextNode(question.getExtraInformation()));
        rootElement.appendChild(extraInformation);

    }

    /**
     * Converts a QuestionType to a string representing the QuestionType
     * 
     * @param questionType the QuestionType
     * @return
     */
    private String getQuestionTypeString(QuestionType questionType) {
        if (questionType == QuestionType.MULTIPLEANSWER)
            return "multipleanswer";
        else if (questionType == QuestionType.MULTIPLECHOICE)
            return "multiplechoice";
        else
            return "speed";
    }

    public static void main(String[] args) {
        try {
            new QuestionSaver().saveQuestion(new Question());
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}