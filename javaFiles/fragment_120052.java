Runnable x = new Runnable(){
        @Override
        public void run(){
            while(my_list_counter > 0){ 
               random_counter = rand.nextInt(my_list_counter);
               make_words_with_letters.add(list_of_letters.get(random_counter));
               for(Button b:button_list)
                   if (b.getText().equals("")){
                       b.setText(list_of_letters.get(random_counter));
                       list_of_letters.remove(list_of_letters.get(random_counter));
                       my_list_counter--;
                       break;
                   } 
               }
        }
    };