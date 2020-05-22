set position for each item using setTag inside onCreateViewHolder method after that when you'll click then inside onclick you get a view reference from there, get that tag and convert to int( this will give you position of view)

onCreateViewHolder(............){
View view;
view.setTag(id, position);
view.setOnTouch or Onclick(View v){
String position = v.getTag(),toString();
// get your id using this position
}
}