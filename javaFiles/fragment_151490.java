if(position==1){

//here change color or hide view

holder.someView.setVisibility(View.Invisible);

holder.someView.setColor ==== green; //forgive me abt syntx

}else{

//Here in else part it is important that you must reverse above things
//so that when you scroll list, GREEN color do not show up in random rows

holder.someView.setVisibility(View.Visible);

holder.someView.setColor ==== red; //forgive me abt syntx

}

//same is for on click listener etc