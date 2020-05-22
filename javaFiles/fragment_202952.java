/**
* Redefine {@code component-scan} to scan the module folder in addition to classpath
* @author Ludovic Guillaume
*/
public class ModuleContextNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("component-scan", new ModuleComponentScanBeanDefinitionParser());
    }
}