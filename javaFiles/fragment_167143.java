public class XMLContentHandler implements ContentHandler {

        @Inject
        private XMLParser xmlParser;

        @Inject
        private XMLMapper xmlMapper;


        public void parse() { 
            xmlParser.parse();
        }

        public void map() { 
            xmlMapper.map();
        }
}