public View getView(int position, View convertView, ViewGroup parent) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.addtaskcustomlayout,null);
        EditText task = (EditText) view.findViewById(R.id.taskadd);
        task.setId(position);
        task.setText(tasks.get(position));
        TextWatcher tw = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {

                 tasks.set(position,s.toString());
            }
        };

        task.addTextChangedListener(tw);

        return view;
    }