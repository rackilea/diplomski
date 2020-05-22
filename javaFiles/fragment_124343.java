double sum = 0;
for (Book b : books){
    if (b.year >= 2000) {} 
    sum += b.price;
} 
System.out.println(sum);
if (books.length > 0) {
    System.out.println(sum / books.length);
}