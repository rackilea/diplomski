@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v =inflater.inflate(R.layout.tab_wc_bank_terminus,container,false);       
    TextView txt = (TextView)v.findViewById(R.id.WCBank_textView1);
    txt.setText(Html.fromHtml("<font color='#FFD300'>text0</font>" +
                    "<font color='#00A4A7'> text1</font>" +
                    "<font color='#E32017'> text2</font>" +
                    "<font color='#FFFFFF'> text3</font>"
    ));
    return v;
}