private int _idLayout;

public ListAdapter(Context context, int idLayout) {
    super(context, idLayout);
    _idLayout = idLayout;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView==null){
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(_idLayout, parent, false);
    }

    return convertView;
}