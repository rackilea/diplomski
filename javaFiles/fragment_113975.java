int id = p1.getId();
//button clicked
if(id == R.id.button_contar){
    int current = Integer.parseInt(this.mViewHolder.contados.getText().toString());
    current++;
    this.mViewHolder.contados.setText(String.format("%.0f", current));
}