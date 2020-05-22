public static void main(String[] args) throws Exception {
    InputStream stream = new FileInputStream("imdb.xml"); // use your stream source
    JAXBContext ctx = JAXBContext.newInstance(Root.class);
    Unmarshaller um = ctx.createUnmarshaller();
    JAXBElement<Root> imdb = um.unmarshal(new StreamSource(stream), Root.class);
    System.out.println(imdb.getValue().movie.plot);
}

public class Root {
    @XmlElement(name="movie")
    public Movie movie;    
}

public class Movie {
    @XmlAttribute(name="plot")
    public String plot;
    // Add fields for other attributes you want to read
}