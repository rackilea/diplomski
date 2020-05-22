View view = getActivity().findViewById(R.id.btnSave);
view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveSetting(v);
            }
        });