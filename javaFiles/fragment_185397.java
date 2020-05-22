abstract class MappedRecord implements java.util.Map<String, Object> {

    private ClassMetadata classMeta;

    public MappedRecord() {
        classMeta = mySessionFactory.getClassMetadata(this.getClass());
    }

    public Object put(String s, Object o) {
        classMeta.setPropertyValue(this, s, o, EntityMode.POJO);
    }
}