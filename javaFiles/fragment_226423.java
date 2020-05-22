shootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mCamera.takePicture(null, null, photoCallback);
            }
        });