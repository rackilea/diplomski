public class AgenAdapter extends BaseAdapter {
List<yourObj> list;
Activity a;
    public AgenAdapter(Activity activity,List<yourObj> list) {
       this.a=activity;
       this.list=list;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();///////return size of list
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;///// dont return null here
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;/////////return position as itemID
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layout = getLayoutInflater();
        View view= layout.inflate(R.layout.list_item,parent,false);

        TextView ATASAN = (TextView) findViewById(R.id.atasan);
        TextView NAMA_AGEN= (TextView) findViewById(R.id.nama_agen);
        TextView KODE_AGEN= (TextView) findViewById(R.id.kode_agen);
        TextView NO_AAJI= (TextView) findViewById(R.id.no_aaji);
        TextView JENIS= (TextView) findViewById(R.id.jenis);
        return view;
    }
}