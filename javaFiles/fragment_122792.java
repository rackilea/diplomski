import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Properties;

import org.hibernate.MappingException;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.MySQLInnoDBDialect;

/**
 * Problem: Hibernate 4.x Schema Export tool does not pay attention to
 * jsr303 annotations for ddl generation.
 * 
 * This class fixes that problem. (use it instead of {@link Configuration}).
 * 
 * This integration is usually performed by BeanValidationIntegrator.
 * Unfortunately, that integration will only be activated upon
 * initialization of the ServiceRegistry, which initializes
 * DatasourceConnectionProviderImpl, which looks up the datasource,
 * which requires a JNDI context ...
 * We therefore reimplement the relevant parts of BeanValidatorIntegrator.
 * Since that must occur after secondPassCompile(), which is invoked by
 * Configuration.generateSchemaCreationScript, which is invoked by
 * SchemaExport, some fancy subclassing is needed to invoke the integration
 * at the right time.
 * 
 * https://forum.hibernate.org/viewtopic.php?f=1&t=1014535
 */
public class ConfigurationWithBeanValidation extends Configuration {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6277290406810542021L;

    @Override
    protected void secondPassCompile() throws MappingException {
        super.secondPassCompile();

        try {
            // thank you, hibernate folks, for making this useful class package private ...                
            Method applyDDL = Class.forName("org.hibernate.cfg.beanvalidation.TypeSafeActivator").getMethod("applyDDL",
                    Collection.class,
                    Properties.class,
                    MySQLInnoDBDialect.class);
            applyDDL.setAccessible(true);
            applyDDL.invoke(null, classes.values(), getProperties(), MySQLInnoDBDialect.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}