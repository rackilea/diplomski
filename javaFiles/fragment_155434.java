mFirebaseDatabase = FirebaseDatabase.getInstance().getReference().child("Accounts").child("Users").child(user.getUid());
                            mFirebaseDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    String value = dataSnapshot.child("type").getValue(String.class);
                                    if(Integer.parseInt(value) == 1) {
                                        startActivity(new Intent(LoginActivity.this, UserActivity.class));
                                        Toast.makeText(LoginActivity.this, "Welcome User", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }else {
                                        startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                                        Toast.makeText(LoginActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }

                                }