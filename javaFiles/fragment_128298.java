class Example {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        props.put("dcoref.score", true);
        pipeline = new StanfordCoreNLP(props);
        Annotation document = new Annotation("The atom is a basic unit of matter, it   consists of a dense central nucleus surrounded by a cloud of negatively charged electrons.");

        pipeline.annotate(document);
        Map<Integer, CorefChain> graph = document.get(CorefChainAnnotation.class);

        println aText

        for(Map.Entry<Integer, CorefChain> entry : graph) {
          CorefChain c =   entry.getValue();                
          println "ClusterId: " + entry.getKey();
          CorefMention cm = c.getRepresentativeMention();
          println "Representative Mention: " + aText.subSequence(cm.startIndex, cm.endIndex);

          List<CorefMention> cms = c.getCorefMentions();
          println  "Mentions:  ";
          cms.each { it -> 
              print aText.subSequence(it.startIndex, it.endIndex) + "|"; 
          }         
        }
    }
}