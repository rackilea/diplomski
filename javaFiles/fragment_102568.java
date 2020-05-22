MyFragment extends Fragment implements CustomAdapter.EventListener {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CustomAdapter adapter = new CustomAdapter(..., this);

    }

    void onEvent(int data) {
        doSomething(data);
    }

}

CustomAdapter extends BaseAdapter {

    EventListener listener; 

    public interface EventListener {
        void onEvent(int data);   
    }

    public CustomAdapter(..., EventListener listener) {
        this.listener = listener; 
    }

    ...

}