versionViewHolder.ClickedView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ArrayDataAt[position] = " New Data to replace Old one ";
            notifyItemChanged(Adapterposition);
        }
    });