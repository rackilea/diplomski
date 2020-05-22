@XmlJavaTypeAdapter(ModelAdapter.class)
public class MyModel extends ModelCom {

    public Model(Graph base) {
        super(base);
    }

    public Model(Graph base, Personality<RDFNode> personality) {
        super(base, personality);
    }

}