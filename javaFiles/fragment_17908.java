class NoteListAdapter extends ArrayAdapter<Note>{
private List<Note> objects;
private List<Note> originalList = new ArrayList<>();
boolean isLongPressed;
//    boolean isChecked;
boolean[] isChecked;

NoteListAdapter(Context context, int resource, List<Note> objects) {
    super(context, resource, objects);
    this.objects = objects;
    this.originalList.addAll(objects);
    isLongPressed = false;
//        isChecked = false;
    isChecked = new boolean[objects.size()];
    for(int i=0; i<isChecked.length; i++) isChecked[i] = false;
}

@Override
public int getCount() {
    return objects.size();
}

@Nullable
@Override
public Note getItem(int position) {
    return objects.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_component, parent, false);
    }

    Note note = getItem(position);
    if (note != null) {
        TextView title = convertView.findViewById(R.id.list_note_title);
        TextView content = convertView.findViewById(R.id.list_note_content_preview);
        TextView date = convertView.findViewById(R.id.list_note_date);
        // setting checkbox logic on the adapter
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);
        // now i wanna toggle checked items from a checkbox on my header
 //  if (isItemsChecked) {
 //           checkBox.setChecked(true);
 //       } else {
 //           checkBox.setChecked(false);
 //       }
        if (isLongPressed) {
            checkBox.setVisibility(View.VISIBLE);
        } else {
            checkBox.setVisibility(View.GONE);
        }
        // also handle checks for all list view items
        checkBox.setChecked(isChecked[position]);
        checkBox.setTag(position);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                int checkedPosition = (int)cb.getTag();
                isChecked[checkedPosition] = cb.isChecked();
                notifyDataSetChanged();
            }
        });
    }
    return convertView;
}

void showCheckbox(int clickedPosition) {
    isLongPressed = true;
    for(int i=0; i<isChecked.length; i++) isChecked[i] = false;
    isChecked[clickedPosition] = true;
    notifyDataSetChanged();  // Required for update
}

void removeCheckbox() {
    isLongPressed = false;
    notifyDataSetChanged();  // Required for update
}

void checkboxAllChange(boolean state) {
    isLongPressed = true;
    for(int i=0; i<isChecked.length; i++) isChecked[i] = state;
    notifyDataSetChanged();  // Required for update
}

//    void Check() {
//        isChecked = true;
//        notifyDataSetChanged();  // Required for update
//    }
//    void Uncheck() {
//        isChecked = false;
//        notifyDataSetChanged();  // Required for update
//    }

}