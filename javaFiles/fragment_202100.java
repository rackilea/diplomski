public String toString()
    {
        return "SerialNumber: " + serialNumber +"\n"
               +"Title: " + title + "\n" 
               +"Author: " + author +"\n";
    }

public void print()
{
    System.out.println(this.toString());

}