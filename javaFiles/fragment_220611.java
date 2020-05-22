public class FacebookSignInPlugin implements MethodCallHandler,
      // Implement PluginRegistry.ActivityResultListener
      PluginRegistry.ActivityResultListener {

  public static void registerWith(Registrar registrar) {
      final MethodChannel channel = new MethodChannel(registrar.messenger(), "my_plugin");
      final FacebookSignInPlugin instance = new MyPlugin();

      // Register your plugin as an ActivityResultListener
      registrar.addActivityResultListener(instance);
      channel.setMethodCallHandler(instance);
  }

  private CallbackManager callbackManager = CallbackManager.Factory.create();

  @Override
  public void onMethodCall(MethodCall call, final Result result) {
  }

  @Override
  public boolean onActivityResult(int i, int i1, Intent intent) {
      // Forward the activity result to the Facebook CallbackManager
      callbackManager.onActivityResult(i, i1, intent);
      return false;
  }
}