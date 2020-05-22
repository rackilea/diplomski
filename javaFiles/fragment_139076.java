import javax.inject.Inject;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

public class TokenFactoryProvider extends AbstractValueFactoryProvider {

    private final TokenFactory tokenFactory;

    @Inject
    public TokenFactoryProvider(
            final MultivaluedParameterExtractorProvider extractorProvider,
            ServiceLocator locator,
            TokenFactory tokenFactory) {

        super(extractorProvider, locator, Parameter.Source.UNKNOWN);
        this.tokenFactory = tokenFactory;
    }

    @Override
    protected Factory<?> createValueFactory(Parameter parameter) {
         Class<?> paramType = parameter.getRawType();
         TokenParam annotation = parameter.getAnnotation(TokenParam.class);
         if (annotation != null && paramType.isAssignableFrom(Token.class)) {
             return tokenFactory;
         }
         return null;
    }
}