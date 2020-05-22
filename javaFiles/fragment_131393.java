ParcelFileDescriptor descriptor = ParcelFileDescriptor.open(file,ParcelFileDescriptor.MODE_READ_ONLY);
Bundle parameters = new Bundle();
parameters.putParcelable(file.getName(),descriptor);
parameters.putString("description","Location");

Request videoRequest = new Request(session,"me/videos", parameters,HttpMethod.POST,
                                     new Request.Callback() {

                                            @Override
                                            public void onCompleted(
                                                    Response response) {

                                                if (response.getError() == null) {
                                                    Toast.makeText(
                                                            AndroidCamera.this,
                                                            "video shared successfully",
                                                            Toast.LENGTH_SHORT)
                                                            .show();
                                                } else {
                                                    System.out
                                                            .println(response
                                                                    .getError()
                                                                    .getErrorMessage());
                                                    Toast.makeText(
                                                            AndroidCamera.this,
                                                            response.getError()
                                                                    .getErrorMessage(),
                                                            Toast.LENGTH_SHORT)
                                                            .show();
                                                }
                                            }
                                        });
// Execute the request in a separate thread
videoRequest.executeAsync();

} catch (FileNotFoundException e) {
    e.printStackTrace();
}