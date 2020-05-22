if (requestCode == RECORD_VIDEO && resultCode == Activity.RESULT_OK && data.getData() != null) {

            Uri filePath = data.getData();

            path = filePath+"";

            ivVideo.setVideoPath(path);
            ivVideo.setMediaController(new android.widget.MediaController(getActivity()));
            ivVideo.requestFocus();
            ivVideo.start();
            Uri selectedImageUri = data.getData();
            selectedPath = getPath(selectedImageUri);

        }