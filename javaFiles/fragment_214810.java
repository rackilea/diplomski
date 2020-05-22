import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.exceptions.DescriptorException;
import org.eclipse.persistence.internal.descriptors.InstantiationPolicy;
import org.eclipse.persistence.internal.security.PrivilegedAccessHelper;
import org.eclipse.persistence.internal.sessions.AbstractSession;

public class FactoryCustomizer implements DescriptorCustomizer{

    @Override
    public void customize(ClassDescriptor descriptor) throws Exception {
        descriptor.setInstantiationPolicy(new MyInstantiationPolicy(descriptor));
    }

    private static class MyInstantiationPolicy extends InstantiationPolicy {

        public MyInstantiationPolicy(ClassDescriptor descriptor) {
            InstantiationPolicy defaultInstantiationPolicy = descriptor.getInstantiationPolicy();
            this.factoryClassName = defaultInstantiationPolicy.getFactoryClassName();
            this.factoryClass = defaultInstantiationPolicy.getFactoryClass();
            this.methodName = defaultInstantiationPolicy.getMethodName();
        }

        @Override
        public void initialize(AbstractSession session) throws DescriptorException {
            super.initialize(session);
        }

        @Override
        protected void initializeMethod() throws DescriptorException {
            Class<?>[] methodParameterTypes = new Class[] {Class.class};
            try {
                this.method = PrivilegedAccessHelper.getMethod(factoryClass, methodName, methodParameterTypes, true);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Object buildNewInstance() throws DescriptorException {
            Object[] parameters = new Object[] {this.descriptor.getJavaClass()};
            try {
                return PrivilegedAccessHelper.invokeMethod(method, factory, parameters);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}