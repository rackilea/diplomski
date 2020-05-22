Talker t = new Talker();

FuncPrinter fp = new FuncPrinter(System.out);
t.sayHello(fp);

ByteArrayOutputStream ostream = new ByteArrayOutputStream();
PrintWriter pw = new PrintWriter(ostream);
fp = new FuncPrinter(pw);
t.sayHello(fp);

fp = new FuncPrinter(
  line -> System.out.println(line),
  () -> System.out.println(42));
t.sayHello(fp);