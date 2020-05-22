public ClassListOnSetupViewHolder(final Context context, View itemView, final List<ClassesBean> classes) {

    super(itemView);

    delete_button_classsetup = itemView.findViewById(R.id.delete_button_classsetup);

    delete_button_classsetup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int adapterPosition = getAdapterPosition();
            if (adapterPosition == RecyclerView.NO_POSITION) {
                return;
            }

            Log.i("Deletes", "Button pressed");
            long id = classes.get(adapterPosition).getId();

            ((ClassListOnSetup) context).removeAt(adapterPosition, classes.get(adapterPosition).getId());
            Toast.makeText(context, "You Clicked ID = " + id, Toast.LENGTH_SHORT).show();
        }
    });

    // ...
 }