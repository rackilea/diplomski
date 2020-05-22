@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup  container, @Nullable Bundle savedInstanceState) {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_kurye_siparis, container, false);
    return view;
}

@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
    super.onViewCreated(view, savedInstanceState);
    //
    tanimla();
    gerek();
    getSip("0");
}

public void gerek()
{
    MaterialButton ekle = (MaterialButton)getView().findViewById(R.id.ekleButton);
    ...
}