final ExecutionContext ec = system.dispatcher();

Future<String> f1 = future(new Callable<String>() {
    public String call() {
        return "Hello" + "World";
    }
}, ec);

Future<Integer> f2 = f1.map(new Mapper<String, Integer>() {
    public Integer apply(String s) {
        return s.length();
    }
}, ec);

f2.onSuccess(new PrintResult<Integer>(), system.dispatcher());