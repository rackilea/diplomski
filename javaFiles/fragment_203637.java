public class ReportComponentFactory {

    private final Map<String, ReportComponent> headerCache = 
        new HashMap<String, ReportComponent>();
    private final Map<GraphParameters, ReportComponent> graphCache = 
        new HashMap<GraphParameters, ReportComponent>();

    public ReportComponent buildHeader(String headerText){
        if (this.headerCache.containsKey(headerText)){
            return this.headerCache.get(headerText);
        }
        Header newHeader = new Header(headerText);
        this.headerCache.put(headerText, newHeader);
        return newHeader;
    }

    public ReportComponent buildGraph(GraphParameters parameters){
        if (this.graphCache.containsKey(parameters)){
            return this.graphCache.get(parameters);
        }
        Graph newGraph = new Graph(parameters);
        this.graphCache.put(newGraph);
        return newGraph;
    }

    ...
}