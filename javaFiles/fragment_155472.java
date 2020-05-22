LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

/* INFLATE MAIN TABLE LAYOUT */
ViewGroup root = (ViewGroup) inflater.inflate(R.layout.table_root, null);
TableLayout tbl = (TableLayout) root.findViewById(R.id.tblLayout);

this.setContentView(root);

ViewGroup row = (ViewGroup) inflater.inflate(R.layout.table_row, root, false);

/* GENERIC LOOP FOR CREATING TABLE */

int count = 1;

for (int day = 0; day < calendarCount; day++)
{
    row.addView(day);

    if (count <= weekCount) {
        root.addView(row);
        row = (ViewGroup) inflater.inflate(R.layout.popup_row, root, false);
    }
    count++;
}