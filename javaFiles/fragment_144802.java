public class DFS {

    public DFS(Graph graph) { ... }   // you have the option to mark this as deprecated 
    public DFS(Graph graph, Source source) { ... }  // New constructor

    public void runDFS() {    // New API
        if (this.source == null) {
            throw new IllegalStateException("Source is null!");
        }
        doRun(this.source);
    }

    // Again you have the option to mark this as deprecated
    public void runDFS(Source source) {
        // handle here the case where client already provided a source with the new 
        // constructor. Should we replace it? Should we throw an exception?
        this.source = source;
        doRun(source);
    }

    private void doRun(Source source) {
        // this is private so it can be called by both runDFS() and runDFS(Source)
        // do whatever you did before here
    }

    public Path getPathFromSource(Vertex vertex) {   // New API
        if (source == null) {
            throw new IllegalStateException("Source is null!");
        }
        // do the job for the new API here      
    }

}