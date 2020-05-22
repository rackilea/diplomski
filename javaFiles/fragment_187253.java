private enum Plant {
    foxtail, orchid, xyz;
}

String value = getPlantFromDB();
Plant plant = Plant.valueOf(value); // surround with try/catch

switch(plant) {
    case foxtail : 
       resId= R.drawable.foxtail
       break;
    case orchid : 
       resId= R.drawable.orchid
       break;
    default : 
       resId= R.drawable.xyz
       break;
Drawable drawable = getResources().getDrawable(resId);
ImageView image = (ImageView)findViewById(R.id.image);
image.setImageDrawable(drawable);