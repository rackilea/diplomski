LinearLayout layout = (LinearLayout) view.findViewById(R.id.image_container)
LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

// Add 4 images

for (int i = 0; i < 4; i++) { 
        layoutParams.setMargins(20, 20, 20, 20);
        layoutParams.gravity = Gravity.CENTER;
        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.drawable.image);
        imageView.setOnClickListener(documentImageListener);
        imageView.setLayoutParams(layoutParams);

        layout.addView(imageView);

    }