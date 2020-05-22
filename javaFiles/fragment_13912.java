public class DFragment extends DialogFragment {

    List<Map<String, String>> mylist;

    public DFragment () {   
        // Empty constructor required for DialogFragment
    }

    public DFragment (List<Map<String, String>> mylist) {
        this.mylist= mylist;
    }

}