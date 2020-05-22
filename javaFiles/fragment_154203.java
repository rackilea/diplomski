public void shareVideoOnTumblr(final File videoFile, final String caption,
        final Handler handler) {

    new Thread(new Runnable() {

        @Override
        public void run() {

            try {
                VideoPost videoPost = client.newPost(client.user()
                        .getBlogs().get(0).getName(), VideoPost.class);

                if (!caption.toString().isEmpty())
                    videoPost.setCaption(caption.toString());
                videoPost.setData(videoFile);
                videoPost.save();
                Bundle bundle = new Bundle();
                Message message = new Message();
                bundle.putInt("method",
                        UploadActivity.SHARED_VIDEO_SUCCESSFULLY);
                message.setData(bundle);
                handler.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
}