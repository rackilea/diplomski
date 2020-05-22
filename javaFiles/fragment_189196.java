private void uploadProfileImage(){
        Log.d(TAG, "uploadProfileImage: uploading image....");
        if (contentUri != null){
            //from gallery
            final StorageReference reference = FirebaseStorage.getInstance().getReference().child(currentUserID).child("profile_photo");
            reference.putFile(contentUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String profilePhotoUri = uri.toString();
                            DatabaseReference publicUserReference = FirebaseDatabase.getInstance().getReference().child("public_user")
                                    .child(currentUserID);
                            HashMap hashMap = new HashMap();
                            hashMap.put("profile_photo", profilePhotoUri);
                            publicUserReference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener() {
                                @Override
                                public void onComplete(@NonNull Task task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(mContext, CompleteProfileActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        }
                    });
                }
            });
        }
    }