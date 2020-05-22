class R3
{
  public void g()
  {
    throw new Error("Unresolved compilation problem: \n\tUnreachable catch block for FileNotFoundException. This exception is never thrown from the try statement body\n");
  }

  public static void main(String[] args)
  {
    System.out.println("23");
  }
}