@Override
public View getView(int position, View convertView, ViewGroup parent){

    if(convertView==null){
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.fragment_membership, null, true);

    }