import org.kubek2k.springockito.annotations.internal.Loader;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.GenericXmlContextLoader;

public class PatchedSpringockitoContextLoader extends GenericXmlContextLoader {

    private final Loader loader = new Loader();

    @Override
    protected void prepareContext(ConfigurableApplicationContext context, MergedContextConfiguration mergedConfig) {
        super.prepareContext(context, mergedConfig);
        this.loader.defineMocksAndSpies(mergedConfig.getTestClass());
    }

    @Override
    protected void customizeContext(GenericApplicationContext context) {
        super.customizeContext(context);
        this.loader.registerMocksAndSpies(context);
    }

}