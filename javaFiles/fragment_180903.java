public class DrinksAdapter extends ArrayAdapter {
List list = new ArrayList();

public DrinksAdapter(@NonNull Context context, @LayoutRes int resource) {
    super(context, resource);
}


public void add(Drinks object) {
    super.add(object);
    list.add(object);
}

@Override
public int getCount() {
    return list.size();
}

@Nullable
@Override
public Object getItem(int position) {

    return list.get(position);
}

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    View row;
    row = convertView;
    DrinkHolder drinkHolder;

    if(row == null) {
        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = layoutInflater.inflate(R.layout.row_layout,parent,false);
        drinkHolder = new DrinkHolder();
        drinkHolder.tx_ime = (TextView) row.findViewById(R.id.tx_ime);
        drinkHolder.tx_kolicina = (TextView) row.findViewById(R.id.tx_kolicina);
        drinkHolder.tx_cijena = (TextView) row.findViewById(R.id.tx_cijena);

        row.setTag(drinkHolder);
    } else {
        drinkHolder = (DrinkHolder) row.getTag();
    }


    final Drinks drinks = (Drinks) this.getItem(position); //make it final
    drinkHolder.tx_ime.setText(drinks.getIme());
    drinkHolder.tx_kolicina.setText(drinks.getKolicina());
    drinkHolder.tx_cijena.setText(drinks.getCijena());
     drinkHolder.tx_ime.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
     //do anything with your **drink** object get any present value
    Log.i("INFO", drinks.getIme()); // you will log whichever text is clicked in Ime of each list item
     }
    }
    return row;

}

static class DrinkHolder {
    TextView tx_ime,tx_kolicina,tx_cijena;
}

}