@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == Constantes.REQUEST_CODE_ADD_PICTURE && resultCode == RESULT_OK && data!= null){

            Uri imageUri = data.getData();
            imageProduto.setImageURI(imageUri);
            Toast.makeText(this, "Image Update Successfully!", Toast.LENGTH_SHORT).show();

    }else {
        Toast.makeText(this, "Image Not Updated!", Toast.LENGTH_SHORT).show();
    }

}