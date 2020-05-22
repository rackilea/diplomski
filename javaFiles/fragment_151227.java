public class XPathCharacters {
    private SAXBuilder parser = new SAXBuilder();
    private Document characters;
    private XPath pProbs, pContent1, pContent2, pContent3, pContent4, pContent5;
    private List<Attribute> probs1, probs2, probs3, probs4, probs5;
    private List<List<Attribute>> probs;
    private List<String> noNodes;
    private Double[] dprobs;
    private String pathToSourceXml;
    private String content1, content2, content3, content4, content5;
    private int noNode;

    public XPathCharacters(){

    }

    public XPathCharacters(String path, String content1,String content2,String content3,String content4,String content5){
        setPathToSourceXml(path);
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
        this.content4 = content4;
        this.content5 = content5;
        noNode = 0;
        initiate();
    }

    public void initiate() {
        try {
        //Evaluate each XPath expression seperately 
            characters = parser.build(pathToSourceXml);
            pContent1 = XPath.newInstance("/n-grams-sorted/n-gram[contains(.,"+content1+")]/@probability");
            pContent2 = XPath.newInstance("/n-grams-sorted/n-gram[contains(.,"+content2+")]/@probability");
            pContent3 = XPath.newInstance("/n-grams-sorted/n-gram[contains(.,"+content3+")]/@probability");
            pContent4 = XPath.newInstance("/n-grams-sorted/n-gram[contains(.,"+content4+")]/@probability");
            pContent5 = XPath.newInstance("/n-grams-sorted/n-gram[contains(.,"+content5+")]/@probability");

            //Convert the result of the above XPath expressions to nodes
            probs1 = (List<Attribute>) pContent1.selectNodes(characters);
            probs2 = (List<Attribute>) pContent2.selectNodes(characters);
            probs3 = (List<Attribute>) pContent3.selectNodes(characters);
            probs4 = (List<Attribute>) pContent4.selectNodes(characters);
            probs5 = (List<Attribute>) pContent5.selectNodes(characters);

        } catch (JDOMException jdome) {
            System.out.println("Error at XPathInformationgain.initiate(): JDOMException: " + jdome.getMessage());
        } catch (IOException ioe) {
            System.out.println("Error at XPathInformationgain.initiate(): IOException: " + ioe.getMessage());
        }
    }

    private void setPathToSourceXml(String path) {
        this.pathToSourceXml = path;
    }

    public Double[] getProbs(String pathToSourceXml) {
        this.pathToSourceXml = pathToSourceXml;

        probs = new ArrayList();
        probs.add(probs1);
        probs.add(probs2);
        probs.add(probs3);
        probs.add(probs4);
        probs.add(probs5);

        List<Double> theDoubles = new ArrayList();
        dprobs = new Double[5];
        noNodes = new ArrayList();
        int j=0;
        for (int i=0; i<5; i++) {
            if (probs.get(i).size() > 0) {
                System.out.println("i: "+i);
                System.out.println("j: "+j);
               //Add the value of all these nodes to an Array so you can work with them
               theDoubles.add(Double.parseDouble(probs.get(i).get(0).getValue()));
                dprobs[j] = theDoubles.get(j);
            }
            else {
                //If one of the values happens to be a zero-length array, add 0.0 to the array of values
                theDoubles.add(0.0);
            }
        }
        return dprobs;
    }

    public List<String> getNoNodes() {
        return noNodes;
    }
}