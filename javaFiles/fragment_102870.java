package es.buena.jamon.type;

public class SpanishBoolean  extends AbstractSingleColumnStandardBasicType<Boolean> 
              implements PrimitiveType<Boolean>, DiscriminatorType<Boolean> 
{
    private static final long serialVersionUID = 1L;
    public static final SpanishBoolean INSTANCE = new SpanishBoolean(); 


    public SpanishBoolean() { 
            super( CharTypeDescriptor.INSTANCE, new BooleanTypeDescriptor('S', 'N') ); 
    } 
    @Override 
    public String getName() { 
            return "si_no"; 
    } 
    @Override 
    public Class getPrimitiveClass() { 
            return boolean.class; 
    } 
    @Override 
    public Boolean stringToObject(String xml) throws Exception { 
            return fromString( xml ); 
    } 
    @Override 
    public Serializable getDefaultValue() { 
            return Boolean.FALSE; 
    } 
    @Override 
    public String objectToSQLString(Boolean value, Dialect dialect) throws Exception { 
            return StringType.INSTANCE.objectToSQLString( value ? "S" : "N", dialect ); 
    } 
}