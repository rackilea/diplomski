public class ListRequestAdapter extends ArrayAdapter<ListRequestItem> {

    public ListRequestAdapter(Context context, List<ListRequestItem> items){
        super(context, R.layout.style_fragment_list_request, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.style_fragment_list_request,  parent, false);
            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.imgPhoto = (ImageView) convertView.findViewById(R.id.listPhoto);
            viewHolder.tvTanggal = (TextView) convertView.findViewById(R.id.tvTanggalRequest);
            viewHolder.tvTipe = (TextView) convertView.findViewById(R.id.tvTipeRequest);
            viewHolder.tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
            viewHolder.permitid = "";
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // update the item view
        ListRequestItem item = getItem(position);

        // Setup ImageView accord to DataList,
        // may be imageID from DataList.
        if(imageID == null) viewHolder.imgPhoto.setVisibility(View.INVISIBLE);
        else{
             viewHolder.imgPhoto.setImageResource(item.imageID);
             viewHolder.setVisibility(VIEW_VISIBLE);
        }

        viewHolder.tvTanggal.setText(item.tanggal);
        viewHolder.tvTipe.setText(item.tipe);
        viewHolder.tvStatus.setText(item.status);
        viewHolder.permitid = item.permitid;
        return convertView;
    }

    private static class ViewHolder {
        ImageView imgPhoto;
        TextView tvTanggal;
        TextView tvTipe;
        TextView tvStatus;
        String permitid;
    }
}