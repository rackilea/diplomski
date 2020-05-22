int name_index = 0;
int max = Votes[0];
for ( int i = 0 ; i < 5 ; i++){
     if ( max < Votes[i] ){
         max = Votes[i];
         name_index = i;
        }
   }

 String target_name = names[name_index];