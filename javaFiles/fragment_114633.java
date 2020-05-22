int total = 0;
for (Book b : myLibrary)
{
   total += b.price;
   System.out.println(b); // Assuming a valid toString in the Book class
}
System.out.println("The total value of your library is " + total);