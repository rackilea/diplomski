public class CustomListViewAdapter extends ArrayAdapter {

    LayoutInflater inflater;
    List<SocietySearch.ListViewItem> items;

    public CustomListViewAdapter(Activity context, List<SocietySearch.ListViewItem> items) {
        super(context, R.layout.item_row, **items**); // the constructor 
        //needs the reference of the list, even though we use our variable to 
        //populate the rows. I guess it has to know how many elements it contains to
        //iterate then through getView method, which is called for each row

        this.items = items;
        this.inflater = (LayoutInflater) context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE);
    }