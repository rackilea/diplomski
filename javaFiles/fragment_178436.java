public class MainActivity extends Activity{

@Inject
ImageAssistant imageAssistant;

@Override
protected void onCreate(Bundle savedInstanceState) {
    SharedObjectGraph.inject(this);
    imageAssistant.doSomething();
}