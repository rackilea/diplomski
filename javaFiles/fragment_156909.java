@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // choose donation amount
    View viewV = (ViewGroup) inflater.inflate(R.layout.donatefraggoogle, container, false);
    mGoogleEditText = (EditText) viewV.findViewById(R.id.edtDonate);
    return viewV;
}