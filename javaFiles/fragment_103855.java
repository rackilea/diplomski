//buttonlar = container.findViewById(R.id.buttonlar);
        //text = container.findViewById(R.id.text);

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        buttonlar = view.findViewById(R.id.buttonlar);
        //Use the inflated view to get the text (just like you did for buttonlar)
        text = view.findViewById(R.id.text);
        buttonlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("test");
            }
        });
        return view;
    }