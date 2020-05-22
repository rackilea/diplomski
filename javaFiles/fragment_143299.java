public class CountryCodeAdapter extends RecyclerView.Adapter<CountryCodeAdapter.ViewHolder> {

private CountryCodeActivity activity;
ArrayList<CountryCodeModel> list = new ArrayList<>();

int selected_pos = 0;

public CountryCodeAdapter(CountryCodeActivity activity, ArrayList<CountryCodeModel> list) {
    this.activity = activity;
    this.list = list;
}

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_country_listing, parent, false);
    return new ViewHolder(rootView);
}

@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

    holder.tv_row_CountryCodeActivity_countrycode.setText(list.get(holder.getAdapterPosition()).getDial());
    holder.tv_row_CountryCodeActivity_countryname.setText(list.get(holder.getAdapterPosition()).getName());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.putExtra("country_code", list.get(holder.getAdapterPosition()).getDial());
            activity.setResult(activity.RESULT_OK, intent);
            activity.finish();
        }
    });
}

@Override
public int getItemCount() {
    return list.size();
}

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_row_CountryCodeActivity_countryname,
            tv_row_CountryCodeActivity_countrycode;

    public ViewHolder(View itemView) {
        super(itemView);
        tv_row_CountryCodeActivity_countryname = itemView.findViewById(R.id.tv_row_CountryCodeActivity_countryname);
        tv_row_CountryCodeActivity_countrycode = itemView.findViewById(R.id.tv_row_CountryCodeActivity_countrycode);

    tv_row_CountryCodeActivity_countryname.setTypeface(AppClass.Lato_Regular);
        tv_row_CountryCodeActivity_countrycode.setTypeface(AppClass.Lato_Regular);

    }
}
}