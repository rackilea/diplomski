for (int i = 0; i < number - 1; i++){
     for (int j = i + 1; j < number; j++){
          if (items[i] + items[j] == credit){
               System.out.print(i + "," + j + " ");
          }
     }
}