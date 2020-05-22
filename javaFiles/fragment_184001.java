public static void main(String[] args) {


        String str = "aaakkkkkkkbbkkkkk";

        char[] var = str.toCharArray();

        for(int i=0; i<var.length;i++)
            System.out.print(" "+var[i]);


        int final_index=0; // this is for final index what we want

        int max_size=0; // for maximum no. of time the same char repeats continiously..
        int size=0; // this for finding size of sub string..
        char pre_char=var[0]; // pre_char is used check with present char in the array where the i position is shifted..



        // here is the loop..
        // we don't need much loops to this
        // while we are reading , the comparison is also done parallely.. 
        for(int i=1;i<var.length;i++) // here i starts from 1 because 0th char is shfted into pre_char 
            //and now comparion is starts from next char ie from 1th position
        {
//          System.out.println("i=="+i+" size "+size+"  prechar== "+pre_char+ "  var[i] ="+var[i]+" max size=="+max_size);
//          System.out.println("..........................");
            if(pre_char==var[i]) // here condition is checking. if its same with previous char, its means same char is occur again..
            {
                size+=1;
            }else{ // else means the sub string is has different char 
                if(max_size<size) // now check for whether any maximum size is occured priviously or not..
                {
                    max_size=size;
                    final_index=i-size;
                }
                size=0;
            }
            pre_char=var[i];
        }

        // now this for final 
        // its means if the max sub string is at the ending position, the above for loop breaks at the last element 
        // in this case we check if the last sub string is max or not..

        if(max_size<size)
        {
            max_size=size;
            final_index=var.length-size;
        }
        // then this is the final what we wana,,,,, 
        System.out.print("Max size is "+(max_size+1)+"  index is "+final_index);



    }