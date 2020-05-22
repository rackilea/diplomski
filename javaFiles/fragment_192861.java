public void println(String paramString)
{
  synchronized (this)
  {
    print(paramString);
    newLine();
  }
}