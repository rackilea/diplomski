private Context _context;
private List<String> _listDataHeader; // header titles
// child data in format of header title, child title
private HashMap<String, List<String>> _listDataChild;
private IExpandableListInterface mMyInterface;

public ExpandableListAdapter(Context context, IExpandableListInterface myInterface, List<String> listDataHeader,
                             HashMap<String, List<String>> listChildData) {
    this._context = context;
    this._listDataHeader = listDataHeader;
    this._listDataChild = listChildData;
    this.mMyInterface = myInterface;
}