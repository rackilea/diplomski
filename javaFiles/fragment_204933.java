public class Adapter extends BaseAdapter {

/** VARIABILI */
ArrayList<Row> rows = new ArrayList<>();
Context c;
LayoutInflater inflater;
static int cambiobandiera=0; /** SE 0 E' VERDE, SE 1 E' ROSSA

/** COSTRUTTORE */
public Adapter(Context context, ArrayList<Row> rows)
{
    super(context, R.layout.rigatabella);
    this.c = context;
    this.rows = rows;
}

public int getCount() {
    return rows.size();
}

public Row getItem(int position) {
    return rows.get(position);
}

public class ViewHolder
{
    ImageView bandiera;
    TextView ntavolo;
    TextView piatto;
    TextView qta;
    ImageView positivo;
    ImageView negativo;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    Row row = getItem(position);
    // Here use row to fill in your textviews etc. You'll need to add getters to the Row model


    holder.negativo.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            rows.remove(position); // This removes the row from the dataset
            notifyDataSetChanged(); // This tells the adapter to update (to show the change on screen)
        }
    });

    return convertView;
}