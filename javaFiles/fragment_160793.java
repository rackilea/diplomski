public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl();
            downloadUrl.addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    Log.v(TAG, "Media is uploaded");

                    String downloadURL = "https://" + task.getResult().getEncodedAuthority()
                            + task.getResult().getEncodedPath()
                            + "?alt=media&token="
                            + task.getResult().getQueryParameters("token").get(0);

                    Log.v(TAG, "downloadURL: " + downloadURL);
                    //save your downloadURL
                }
            });
        }