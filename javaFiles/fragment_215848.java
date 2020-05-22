if(maze.isGameComplete()) {
   AlertDialog.Builder builder = new AlertDialog.Builder(context);
   builder.setTitle(context.getText(R.string.finished_title));
   LayoutInflater inflater = context.getLayoutInflater();
   View view = inflater.inflate(R.layout.finish, null);
   builder.setView(view);
   View closeButton =view.findViewById(R.id.closeGame);

   closeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View clicked) {
         if(clicked.getId() == R.id.closeGame) {
            context.finish();
         }
      }
   });

   AlertDialog finishDialog = builder.create();
   finishDialog.show();
}