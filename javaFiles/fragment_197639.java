@XmlSeeAlso({ MagSpecs.class, RegSpecs.class })
@XmlJavaTypeAdapter(MyAdapter.class) // Never needed this annotation myself...
public interface Specs {
    public BaseProperties getBaseProps();
    public void setBaseProps(BaseProperties baseProps);
}