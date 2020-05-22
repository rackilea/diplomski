public void shareImageOnTumblr(final File imgFile, final String caption,
            final Handler handler) {
        new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    PhotoPost photoPost = client.newPost(client.user()
                            .getBlogs().get(0).getName(), PhotoPost.class);
                    if (!caption.isEmpty())
                        photoPost.setCaption(caption);

                    photoPost.setPhoto(new Photo(imgFile));
                    photoPost.save();
                    Bundle bundle = new Bundle();
                    Message message = new Message();
                    bundle.putInt("method",
                            UploadActivity.SHARED_PHOTO_SUCCESSFULLY);
                    message.setData(bundle);
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }