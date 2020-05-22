byte [] arr = new byte[10];
FileOutputStream out = ...
out.write(arr, 5, 5); // writes the last 5 bytes of the file, skipping the first 5
out.write(arr, 0, 10); // writes all the bytes of the array
out.write(arr, 5, 10); // ERROR! index out of bounds, 
                       // your attempting to write 10 bytes starting at offset 5