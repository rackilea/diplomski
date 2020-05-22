public class Manual 
{
String serialNumber, title, author;


public Manual(String serialNumber, String title, String author)
{
setSerialNumber(serialNumber);
setTitle(title);
setAuthor(author);
}

//// serial number

public void setSerialNumber(String number)
{
serialNumber = number;
}


public String getserialNumber()
{
return serialNumber;
}

public void setTitle(String mytitle)
{
    title = mytitle;
}
public String getTitle()
{
    return title;
}

public void setAuthor(String myAuthor)
{
author = myAuthor;
}
public String getAuthor()
{
return author;
}

public void print()
{
System.out.println("Serial Number : " +serialNumber);
System.out.println("Title : " +title);
System.out.println("Author : " +author);
}

public void print(String heading)
{
System.out.println(heading);
printing();
}


public String toString()
{
return "SerialNumber: " + serialNumber +"\n"
+"Title: " + title + "\n" 
+"Author: " + author +"\n";
}

public void printing()
{
System.out.println(this.toString());

}
}