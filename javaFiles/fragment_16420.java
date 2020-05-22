Arraylist<Item> yourlist = new Arraylist();

       @Override 
        public void onClick(View v) {
            // position = pass the current position of the object you want
            passData(int position);

        } 
    }); 

} 

private void passData(int position) { 
    Todo item = new Todo();
    Intent i = new Intent(c, Details.class);
    i.putExtra("nazivTodoa", yourlist.get(position).getTitle());
    i.putExtra("datumTodoa", yourlist.get(position).item.getRecordDate());
    i.putExtra("idTodoa",    yourlist.get(position).item.getItemId());
    c.startActivity(i);
}