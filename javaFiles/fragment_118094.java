holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
((MainActivity) view.getContext()).getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_list_container, new DetailsFrgament())
                        .commit();
            }
        });