public class GraphHopperWithPaths extends GraphHopper {

public List<Integer> routePaths(double startY, double startX, double endY, double endX){

    //Examine a route and return edgeIDs that GraphHopper uses
    LocationIndex index = this.getLocationIndex();
    GHRequest request = new GHRequest(startY, startX, endY, endX);
    GHResponse response = new GHResponse();
    List<Path> paths = getPaths(request, response);
    List<Integer> edges = new ArrayList<Integer>();
    for(Path p:paths){
        for(EdgeIteratorState e:p.calcEdges()){
            edges.add(e.getEdge());
        }
    }
    if (response.hasErrors()) return null;

    //Get edges for start and end point as well
    QueryResult qr = index.findClosest(startY, startX, EdgeFilter.ALL_EDGES );
    edges.add(qr.getClosestEdge().getEdge());
    qr = index.findClosest(endY, endX, EdgeFilter.ALL_EDGES );
    edges.add(qr.getClosestEdge().getEdge());

    return edges;
}

}