package com.example.breno.seenme;

public class CustomAdapter extends ArrayAdapter<ItemCultural> {

    public static final int VIEW_TYPE_MAINACTIVITY = 124; // or some random int.
    public static final int VIEW_TYPE_TELACADAS = 125; // or some random int.

    private int viewType;
    List<ItemCultural> lista;
    private final LayoutInflater mInflater;
    private int resource;

    public CustomAdapter(Context context, int textViewResourceId, int viewType) {
        super(context, textViewResourceId);
        this.viewType = viewType;
        mInflater = LayoutInflater.from(context);
    }

    public CustomAdapter(Context context, int resource, List<ItemCultural> items, int viewType) {
        super(context, resource, items);
        this.viewType = viewType;
        this.lista = items;
        mInflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = mInflater.inflate(resource, parent, false);
        } else {
            v = convertView;
        }
        if (viewType == VIEW_TYPE_MAINACTIVITY) {
            // DO your logic for mainActivity version of the list.
            // I Think the code to hide elements with isConsumido = true
            if (!lista.get(position).isConsumido()) {
                //showThisView(v);
                v.setVisibility(View.GONE);
            } else {
                v.setVisibility(View.VISIBLE);
                ((TextView)v).setText(lista.get(position).toString());
            }
        } else if (viewType == VIEW_TYPE_TELACADAS) {
            // DO your logic for Telacadas version of the list
        } else {
            // UNSUPPORTED VIEW TYPE.
        }
        return v;
    }
}