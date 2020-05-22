public class currentjobAdapter extends BaseAdapter {
String[] Reg;
Context C;
public currentjobAdapter() {
    Reg = null;
}

public currentjobAdapter(Context c, String[] reg){
 this.C = c;
    Reg = reg;
}
@Override
public int getCount() {
    return Reg.length;
}

@Override
public Object getItem(int i) {
    return null;
}

@Override
public long getItemId(int i) {
    return i;
}

@Override
public View getView(final int i, View convertView, ViewGroup viewGroup) {
    final View row;


    if (convertView == null) {

        row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.YourCustomList, viewGroup, false);

    } else {
        row = convertView;
    }


   TextView tv1 =  row.findViewById(R.id.yourid);
    tv1.setText(Reg[i]);
    final String[] date = new String[1];
    String registration = Reg[i];
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbref = db.getReference().child(registration).child(registration);
    dbref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            date[0] = dataSnapshot.child("date").getValue(String.class);

            TextView tv2 = (TextView) row.findViewById(R.id.yourid2);
            tv2.setText(date[0]);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    return row;
}