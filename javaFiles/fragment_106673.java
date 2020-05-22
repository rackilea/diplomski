@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CONTENT_CODE_ADD){
            if(resultCode == 2){


                ArrayList<Contact> myList = (ArrayList<Contact>) data.getSerializableExtra("mylist");
                if(myList != null) {

            empty.setText(myList.get(0).getName().toString());
                }
            }
        }
    }