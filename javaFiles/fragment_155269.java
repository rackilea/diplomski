public class LastCallAdapter extends RecyclerView.Adapter<LastCallAdapter.ViewHolder> {

private LayoutInflater layoutInflater;
private Context mContext;
private ArrayList<String> phoneNumber;

public LastCallAdapter(Context mContext, ArrayList<String> phoneNumber) {
    this.mContext = mContext;
    this.phoneNumber = phoneNumber;
}


@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View view = layoutInflater.from(parent.getContext()).inflate(R.layout.items_contacts, parent, false);
    ViewHolder holder = new ViewHolder(view);
    return holder;
}

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

    holder.number.setText(phoneNumber.get(position));

    holder.parentLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent callDial = new Intent(Intent.ACTION_DIAL);
            callDial = callDial.setData(Uri.parse("tel:"+phoneNumber.get(position)));
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                mContext.startActivity(callDial);
                return;
            }
            Toast.makeText(mContext, phoneNumber.get(position), Toast.LENGTH_SHORT).show();
        }
    });

}

@Override
public int getItemCount() {
    return phoneNumber.size();
}

public class ViewHolder extends RecyclerView.ViewHolder{

    TextView number;
    LinearLayout parentLayout;

    public ViewHolder(View itemView) {
        super(itemView);

        number = itemView.findViewById(R.id.contact_number);
        parentLayout = itemView.findViewById(R.id.parent_layout);

    }
}



}