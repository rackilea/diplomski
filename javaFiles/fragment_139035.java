String title;
String Edition;

public Book()
{

}
public Book(String title,String Edition)
{
    this.title=title;
    this.Edition=Edition;
}

@Override
public String toString() {
    return   title + '\'' +
              Edition ;
}