listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { 
      @Override 
      public void onItemClick(AdapterView<?> parent, View view,int position, long id) { 
      yourTextView.setText(text[position]);
      yourImageView.setImageResource(images[position]);
      } 
 });