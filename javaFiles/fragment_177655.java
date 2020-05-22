Button button=(Button) view.findViewById(R.id.delete_entry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                times.remove(position);
                notifyDataSetChanged();
            }
        });