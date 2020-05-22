public class CustomSequenceGenerator extends SequenceStyleGenerator implements Configurable {

    private String sequenceCallSyntax;

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        sequenceCallSyntax = "SELECT nextval('" + params.getProperty("sequence_name") + "')";
        super.configure(type, params, serviceRegistry);
    }

    @Override
    public Serializable generate(SessionImplementor s, Object obj) {
        Serializable id = s.getEntityPersister(null, obj).getClassMetadata().getIdentifier(obj, s);

        if (id != null && Integer.valueOf(id.toString()) > 0) {
            return id;
        } else {        
            Integer seqValue = ((Number) Session.class.cast(s)
                .createSQLQuery(sequenceCallSyntax)
                .uniqueResult()).intValue();
            return seqValue;
        }
    }


}