import com.fasterxml.jackson.databind.module.SimpleModule;

public class MyModule extends SimpleModule{
  public MyModule() {
    super("ModuleName");
  }
  @Override
  public void setupModule(SetupContext context){
    context.setMixInAnnotations(BaseBean.class, MixIn.class);   
  }
}