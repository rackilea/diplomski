// Inside the Fragment body
private SepProductModel sepProductModel;


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_about_prod_prepare_base, parent, false);
    ButterKnife.bind(this, view);
    Log.e("PrepBaseProdFragment", "PrepBaseProdFragment");
    if(this.sepProductModel != null)
        text.setText(this.sepProductModel.getPROPERTY_PR_SUBSTRPREP_UA_VALUE().getTEXT());
    return view;
}

public void setDataInf(SepProductModel sepProductModel) {
     if(text != null){
         // use text 
     }
     else this.sepProductModel=sepProductModel;
}