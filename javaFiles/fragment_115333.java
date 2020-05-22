@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "param_object_type", propOrder = {
    "object"
})
public class ParamObjectType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    protected List<ParamObjectType.Object> object;

    /**
     * Gets the value of the object property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the object property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParamObjectType.Object }
     * 
     * 
     */
    public List<ParamObjectType.Object> getObject() {
        if (object == null) {
            object = new ArrayList<ParamObjectType.Object>();
        }
        return this.object;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="object" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "object"
    })
    public static class Object
        implements Serializable
    {

        private final static long serialVersionUID = 2L;
        @XmlElementRef(name = "object", type = ParamObjectType.Object.Object2 .class, required = false)
        protected List<ParamObjectType.Object.Object2> object;

        /**
         * Gets the value of the object property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the object property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getObject().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ParamObjectType.Object.Object2 }
         * 
         * 
         */
        public List<ParamObjectType.Object.Object2> getObject() {
            if (object == null) {
                object = new ArrayList<ParamObjectType.Object.Object2>();
            }
            return this.object;
        }

        public static class Object2
            extends JAXBElement<java.lang.Object>
        {

            protected final static QName NAME = new QName("", "object");

            public Object2(java.lang.Object value) {
                super(NAME, ((Class) java.lang.Object.class), ParamObjectType.Object.class, value);
            }

            public Object2() {
                super(NAME, ((Class) java.lang.Object.class), ParamObjectType.Object.class, null);
            }

        }

    }

}