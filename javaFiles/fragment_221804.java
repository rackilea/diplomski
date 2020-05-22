for(int row=0; row < number_of_meds; row++){
   for(int column=0; column < 5; column++){
      index_of_medication = (column * number_of_meds) + row
      array2d[row][column] = med[index_of_medication];
   }
}