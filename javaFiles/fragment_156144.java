public class MyLanguageRuntimeModule extends my.language.AbstractMyLanguageRuntimeModule {
    public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
        return my.language.generator.MyLanguageGenerator.class;
    }

    public Class<? extends ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
        return MyLanguageSyntaxErrorMessageProvider.class;
    }
}