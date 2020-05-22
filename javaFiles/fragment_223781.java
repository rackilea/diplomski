public class MyScriptTemplateViewResolver extends ScriptTemplateViewResolver {

    private ScriptTemplateConfig scriptTemplateConfig;

    public void setScriptTemplateConfig(ScriptTemplateConfig scriptTemplateConfig) {
        this.scriptTemplateConfig = scriptTemplateConfig;
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        MyScriptTemplateView view = (MyScriptTemplateView) super.buildView(viewName);
        view.setScriptTemplateConfig(scriptTemplateConfig);
        return view;
    }

    @Override
    protected Class<?> requiredViewClass() {
        return MyScriptTemplateView.class;
    }

}