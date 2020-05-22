public class DevListAdapter extends ArrayAdapter<Devices>{

Context context; 
int layoutResourceId;    
Devices data[] = null;
private TextView txt = null;

public DevListAdapter(Context context, int layoutResourceId, Devices[] data) {
    super(context, layoutResourceId, data);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data = data;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    Log.d("WCAM","GetView");
    DeviceHolder holder = null;
    Devices devices = data[position];
    String id = devices.id;

    Log.d("WCAM","Inflator");
        Log.d("WCAM","True");
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new DeviceHolder();
        holder.devTxt = (TextView)row.findViewById(R.id.devdesc);
        holder.nameTxt = (TextView)row.findViewById(R.id.devname);
        holder.toggleSwitch = (Switch)row.findViewById(R.id.toggleswitch);
        holder.txt = (TextView) row.findViewById(R.id.debug);
        final int i;

        if(id.matches("1")) {
            i = 0x31;
        }
        else if(id.matches("2")) {
            i = 0x32;
        }
        else if(id.matches("3")) {
            i = 0x33;
        }
        else if(id.matches("4")) {
            i = 0x34;
        }
        else if(id.matches("5")) {
            i = 0x35;
        }
        else if(id.matches("6")) {
            i = 0x36;
        }
        else if(id.matches("7")) {
            i = 0x37;
        }
        else {
            i = 0x38;
        }
        holder.toggleSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Control._service.write(i);
            }
         });

    holder.devTxt.setText(devices.dev);
    holder.nameTxt.setText(devices.name);
    holder.txt.setText(id);

    return row;
}