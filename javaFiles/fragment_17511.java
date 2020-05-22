id = housenumber.next();
line = housenumber.nextLine();
if(input.equals(id))
{    
    //This should the next line instead of just "It's found"
    JOptionPane.showMessageDialog(null,line);

    //Assuming the above file layout, you could then do something like this:
    String[] parts = line.split("\\s+"); //Splits on whitespace

    System.out.println("name: " + parts[0]);
    System.out.println("gender: " + parts[1]);
    System.out.println("age: " + parts[2]);
    break;
}