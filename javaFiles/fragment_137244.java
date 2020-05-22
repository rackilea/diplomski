public class Test {
    private d d;
    public d getD() {return d;}
    public void setD(d d) {this.d = d;}    
    public static class d{
        private List<Results> results;
        public List<Results> getResults() {return results;}
        public void setResults(List<Results> results) {this.results = results;}
    }
    public static class Results {
        public Metadata __metadata;
        public String Synonym;
    }
    public static class Metadata {
        private String uri;
        private String type;
        public String getUri() {return uri;}
        public void setUri(String uri) {this.uri = uri;}
        public String getType() {return type;}
        public void setType(String type) {this.type = type;}
    }
}