if (convertView == null)
{
    EditText txtSrc = new EditText(context);
    EditText txtDes = new EditText(context);
    Button btnTranslate = new Button(context);
    btnTranslate.setText("translate");

    rl = new RelativeLayout(context);
    rl.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    rl.addView(txtSrc);
    rl.addView(btn_translate);
    rl.addView(txtDes);

    holder = new ViewHolder();
    holder.txtSrc = txtSrc;
    holder.btnTranslate = btnTranslate;
    holder.txtDes = txtDes;

    convertView = rl;
}