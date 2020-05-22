holder.itemListDialog_edtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     // We can get the fragment manager
                   f_manager.beginTransaction()
                        .replace(R.id.newAddressContent, new NewAddressFragment())
                        .commit();

            }
        })
    ;