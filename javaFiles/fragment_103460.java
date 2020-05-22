Scanner transfer = new Scanner (new FileInputStream(a));
// we use a simple for loop to set every variable of the object to the file's order.
for (int i = 0 ; i< Array.length; i++){
    Scanner s2= new Scanner(transfer.nextLine())
    Array[i].setLong(s2.nextLong());
    Array[i].setString(s2.next());
    Array[i].setInt(s2.nextInt());
    Array[i].setString(s2.next());
    Array[i].setDouble(s2.nextDouble());
    Array[i].setInt(s2.nextInt());
    s2.close();
    }
transfer.close();