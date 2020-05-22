@Accessors(prefix = "m")
public class AdapterDelegate {
    @Getter @Inject Lazy<FlatAdapter> mFlatAdapterLazy;
    public AdapterDelegate(){
       MyApplication.getComponent(MyApplication.getContext()).inject(this);
    }

    public static AdapterDelegate get() {
        return new AdapterDelegate();
    }
}