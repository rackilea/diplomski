DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference freezerItemsRef = rootRef.child("FreezerItems");
holder.mDeleteBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            freezerItemsRef.child(freezerItems.getId()).removeValue();
        }
    });