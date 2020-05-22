public class CustomListAdapter extends ArrayAdapter<Container>

private final Activity context;
LayoutInflater inflater;

public CustomListAdapter(Activity context, Container[] containers) {
    super(context, R.layout.mylist, containers); 
    this.context=context;
}