public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view,
        ViewGroup parent) {

    ExpandListChild child = (ExpandListChild) getChild(groupPosition, childPosition);
    LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    view = infalInflater.inflate(R.layout.child_layout, null);

    ArrayList<HashMap<String,String>> inputDetailsList = child.getInputfields();

    RadioGroup rg = (RadioGroup) view.findViewById(R.id.radiogroup);
    int has_radiogroup = 0;

    for (int i = 0; i <inputDetailsList.size(); i++){

        if (inputDetailsList.get(i).get("type").equals("radio")){
            System.out.println("type: "+inputDetailsList.get(i).get("type"));
            has_radiogroup = 1;
            RadioButton rb = new RadioButton(rg.getContext());
            rb.setText(inputDetailsList.get(i).get("textcontent"));
            System.out.println("textcontent: "+inputDetailsList.get(i).get("textcontent"));
            rb.setId(Integer.parseInt(inputDetailsList.get(i).get("value")));

            if (has_radiogroup == 1){
                rg.addView(rb);
            }
        }
    }

    return view;
}