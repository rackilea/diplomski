EditText ed;
List<EditText> allEds = new ArrayList<EditText>();

for (int i = 0; i < count; i++) {   

    ed = new EditText(Activity2.this);
    allEds.add(ed);
    ed.setBackgroundResource(R.color.blackOpacity);
    ed.setId(id);   
    ed.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
            LayoutParams.WRAP_CONTENT));
    linear.addView(ed);
}