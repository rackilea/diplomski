public class NewsAdapter extends ArrayAdapter<Articles_Map> {
    Context mContext;

    public NewsAdapter(Context c, int resource) {
        super(c, resource);
        this.mContext = c;
    }

    public NewsAdapter(Context c, int resource, List<Articles_Map> articles) {
        super(c, resource, articles);
        this.mContext = c;
    }