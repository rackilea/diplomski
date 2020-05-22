> InputStream is = new ByteArrayInputStream("hello world".getBytes());
> Scanner sc = new Scanner(is);
> sc.next()
"hello" (String)
> sc.hasNext()
true (boolean)
> sc.nextInLine(".")
" " (String)