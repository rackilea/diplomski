public class TaifunTools extends AndroidNonvisibleComponent {
  private static Context context;
  private static final String LOG_TAG = "TaifunTools";

  public TaifunTools(ComponentContainer container) {    
    super(container.$form());
    this.container = container;
    context = (Context) container.$context();
  }