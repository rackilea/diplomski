
      ImageView img = (ImageView)rootView.findViewById(R.id.imageViewTwitter);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://twitter.com"));
    getActivity().startActivity(intent);    
            }
        });

        ImageView img2 = (ImageView)rootView.findViewById(R.id.imageViewIG);
        img2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/?hl=en"));
    getActivity().startActivity(intent);
            }
        });

        ImageView img3 = (ImageView)rootView.findViewById(R.id.imageViewFB);
        img3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gmail.com"));
    getActivity().startActivity(intent);
                intent.setData(Uri.parse("https://www.facebook.com"));
                startActivity(intent);
            }
        });