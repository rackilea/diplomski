Uri imageUri;

try {

holder.imgPropertyImage.setVisibility(View.VISIBLE);

if(!TextUtils.isNullOrEmpty(propertyItemList.get(position).photo)) {

imageUri = Uri.parse(propertyItemList.get(position).photo);

holder.imgPropertyImage.invalidate();

holder.imgPropertyImage.setImageURI(imageUri);

}

else{

 holder.imgPropertyImage.invalidate();

 holder.imgPropertyImage.setImageURI(null);

 }

 } 
catch (Exception e) {
            e.printStackTrace();

}