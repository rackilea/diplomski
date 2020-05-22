@Override
public void onClick(View v){
  switch(v.getId()){
    case R.id.R.id.imagebutton1:
      startActivity(new Intent(telefoonnummers.class));
      break;
    case R.id.R.id.imagebutton2:
      startActivity(new Intent(telefoonnummers.class));
      break;
    //-- more cases --
  }
}