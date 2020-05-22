builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            myMovieList.remove(position);
            objAdapter.notifyDataSetChanged();
        }
    });