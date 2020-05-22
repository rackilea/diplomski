Button btn = (Button) rootView.findViewById(R.id.new_button);
            btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                  //Do whatever you want
                Intent intent = new Intent(getActivity(), GameActivity.class);
                getActivity().startActivity(intent);
                }
            });