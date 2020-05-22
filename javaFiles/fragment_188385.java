@Module
public class InjectionModule {
Context context;
  public InjectionModule(Context context) {
      this.context = context;
   }

  @Provides
  ListAdapter provideLisAdapter() {
      return new ListAdapter(context);
  }
}