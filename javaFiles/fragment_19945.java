public class Adapter extends RecyclerView.Adapter<Adapter.VHolder> {

private List<MemberListDetails> data;
Context context;

public Adapter(List<MemberListDetails> data, Context context) {
    this.data = data;
    this.context = context;
}

@NonNull
@Override
public Adapter.VHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View view = inflater.inflate(R.layout.item, viewGroup, false);
    return new VHolder(view);
}

@Override
public int getItemCount() {
    return data.size();
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public int getItemViewType(int position) {
    return position;
}

public List<MemberListDetails> getItems() {
    return data;
}

@Override
public void onBindViewHolder(@NonNull Adapter.VHolder vHolder, int i) {
    vHolder.setIsRecyclable(false);
    vHolder.textView.setText(data.get(i).getFirst_name());

    vHolder.editText.removeTextChangedListener(vHolder.textWatcher);
    vHolder.editText.setText(data.get(i).getValue());
    vHolder.editText.addTextChangedListener(vHolder.textWatcher);
}

public class VHolder extends RecyclerView.ViewHolder {
    TextView textView;
    EditText editText;
    TextWatcher textWatcher;

    public VHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.tv_textView);
        editText = itemView.findViewById(R.id.editText2);

        textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
        }

        @Override
        public void afterTextChanged(Editable s) {
            // text.setError(null);
            data.get(getAdapterPosition()).setValue(s.toString());
        }
      };
    }
}

String getValue() {
    StringBuffer x = new StringBuffer();
    for (MemberListDetails a : data) {
        x.append(a.getValue()+",");
    }
    return x.substring(0,x.length()-1);
}