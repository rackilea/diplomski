Hashmap<string,int> colors 

    int max;
    string max_color;

    for(int i=0;i<height;i++) {

      for(int j=0;j<width;j++) {

         int count = 0;
         string red = pixel[i][j].red.to_string;
         string green = pixel[i][j].green.to_string;
         string blue = pixel[i][j].blue.to_string;
         string key = red + "," + green + "," + blue;
         if(hashmap contains pixel[i][j]) {

             count = hashmap.get(key)
             count++;
             hashmap.write(key,count);
         }

         else {
           count = 1;
           hashmap.insert(key,count);  
         }

         if(count > max) {
            max = count;
            max_color = key;
         }

      }



    }

  res = max_color.split(',')