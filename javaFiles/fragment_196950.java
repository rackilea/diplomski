nim2 = nim.getText().toString();
    ruang2 = ruang.getText().toString();
    if (ruangList.contains(ruang2)) {
           Toast.makeText(KelasActivity.this, "this room has already borrow",Toast.LENGTH_LONG).show();
           ruang.setError("you cannot borrow the room again");
    }else if (nimList.contains(nim2)){
           Toast.makeText(KelasActivity.this, "this NIM has borrow the room",Toast.LENGTH_LONG).show();
           nim.setError("you cannot borrow it again");
    }