String line = in.readLine();

 while (line != null)
 {
    String arr [] = line.split ();
    if(arr.length == 3)
    {
            attendee3[0] = arr[0];
            attendee3[1] = arr[1];
            attendee3[2] = arr[2];
    }
   // other count code

   line = in.readLine();
 }