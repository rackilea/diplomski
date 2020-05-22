public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = 0;
    System.out.println("Enter the size of the array:");
    int l = sc.nextInt();
    int m[] = new int[l];
    String n[] = new String[l - 1];
    String s[] = new String[l];
    System.out.println("Enter the integers");
    for (int i = 0; i < l; i++) {
        m[i] = sc.nextInt();
        s[i] = Integer.toString(m[i]);
    }
    System.out.println("Enter the symbols");
    for (int i = 0; i < l - 1; i++) {
        n[i] = sc.next();
    }
    String st = "";
    for (int i = 0; i < l; i++) {
        if (i < (l - 1))
            st = st + s[i] + n[i];
        else
            st = st + s[i];
    }

    System.out.println("String looks like " + st);
    try {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        c = (int) engine.eval(st);
    } catch (NumberFormatException ex) {
        ex.printStackTrace();
    } catch (ScriptException e) {
        e.printStackTrace();
    }
    System.out.println("Answer " + c);
}