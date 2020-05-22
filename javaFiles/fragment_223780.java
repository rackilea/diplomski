public class MyScriptTemplateView extends ScriptTemplateView {

    private ScriptTemplateConfig scriptTemplateConfig;

    public void setScriptTemplateConfig(ScriptTemplateConfig scriptTemplateConfig) {
        this.scriptTemplateConfig = scriptTemplateConfig;
    }

    @Override
    protected ScriptTemplateConfig autodetectViewConfig() throws BeansException {
        ScriptTemplateConfig res = scriptTemplateConfig;
        if (res == null) {
            res = super.autodetectViewConfig();
        }
        return res;
    }

}