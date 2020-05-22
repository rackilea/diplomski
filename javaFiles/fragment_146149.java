package x.y.z;
public class LongGenerator implements IdentifierGenerator { 

        @Override 
        public Serializable generate(final SessionImplementor sessionImplementor, final Object object) throws HibernateException { 
            return new java.util.Date().getTime(); 
        }
}