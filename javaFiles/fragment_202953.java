/**
 * Parser for the {@code <module-context:component-scan/>} element.
 * @author Ludovic Guillaume
 */
public class ModuleComponentScanBeanDefinitionParser extends ComponentScanBeanDefinitionParser {
    @Override
    protected ClassPathBeanDefinitionScanner createScanner(XmlReaderContext readerContext, boolean useDefaultFilters) {
        return new ModuleBeanDefinitionScanner(readerContext.getRegistry(), useDefaultFilters);
    }
}