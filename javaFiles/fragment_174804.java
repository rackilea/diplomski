@Override
public boolean onContextItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.edit:
            AdapterView.AdapterContextMenuInfo tm = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            int position = tm.position;
            editText = adapter.getRef(position);


            editText.child("messageUserId").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(dataSnapshot.getValue())) {
                        editText.child("messageText").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                input.setText(dataSnapshot.getValue().toString());

                                editMessage();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    } else {
                        Toast.makeText(Chat.this, "Запрещено", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
    }
    return true;
}

private void editMessage() {
    sendMessage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.child("messageText").setValue(input.getText().toString());
            Toast.makeText(Chat.this, "Изменено", Toast.LENGTH_SHORT).show();
            input.getText().clear();
            sendMessage();
        }
    });
}

private void sendMessage() {
    sendMessage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (input.getText().toString().trim().equals("")) {
                Toast.makeText(Chat.this, getString(R.string.edittext_null), Toast.LENGTH_SHORT).show();
            } else {
                FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getDisplayName(),
                                FirebaseAuth.getInstance().getCurrentUser().getUid(),
                                payload,
                                avatar,
                                uploadedAttach
                        ));
                input.setText("");
            }
        }
    });
}