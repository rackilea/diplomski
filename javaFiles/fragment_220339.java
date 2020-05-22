String giantRat []={"Bandage", "Healing Potion", "Minor Healing Potion", "Rat Teeth", "Fur", "Rat Tail", ""};


    int[] a = {1,1,1,6,8,3,5};
    int sum = 0;
    for(int i: a)
       sum += i;
    Random r = new Random();
    int s = r.nextInt(sum);  //Get selection position (not array index)

    //Find position in the array:
    int prev_value = 0;
    int current_max_value = 0;
    int found_index = -1;
    for(int i=0; i< a.length; i++){ //walk through the array
      current_max_value = prev_value + a[i];
      //is between beginning and end of this array index?
      boolean found = (s >= prev_value && s < current_max_value)? true : false;
      if( found ){
        found_index = i;
        break;
      }
      prev_value = current_max_value;
    }

    String selection = "unknown";
    if( found_index != -1 ){
      selection = giantRat[found_index];
    }
    System.out.println(selection);