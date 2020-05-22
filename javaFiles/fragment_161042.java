View RV2 = inflater.inflate(R.layout.fragment__dummy,container, false);
LinearLayout LL = (LinearLayout) RV2 .findViewById(R.id.section_label);
EditText ET = new EditText(getActiity());
ET.setText("LOL");
ET.setId(5);
ET.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
LayoutParams.WRAP_CONTENT));
LL.addView(ET);

((ViewGroup)RV2).addView(LL);

return RV2;