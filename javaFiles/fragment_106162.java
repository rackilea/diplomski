file has N bytes to start with
we want to add on "hello world"
open the file for append
append 11 spaces
i=N
loop {
   go back to byte i
   read a byte 
   move to byte i+11
   write that byte back
   i--
} until i==0
then move to byte 0
write "hello world"