// Using equals because you want to compare the String values
// not the reference to memory location for each object
if(input.equals(code)) {
    // Should print true if input value is equal to code value.
    System.out.println("Password entered!"); 
} else { 
    System.out.println("Wrong password!");
}