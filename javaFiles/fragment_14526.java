public class Main {

    public static void main(String[] args) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        int a = 100;
        int b = 200;
        int c = 300;
        int d = 100;
        String[] chars = {"+", "-", "*", "/"};
        try {
            TreeSet<String> set = new TreeSet<>();
        for (int i=0; i<chars.length; i++){
           for (int j=0; j<chars.length; j++){
                for (int k=0; k<chars.length; k++){
                    String expression = a+chars[i]+b+chars[j]+c+chars[k]+d;
                         set.add(String.valueOf(engine.eval(expression)));
                }
            }
        }
        System.out.println(set.size());
        } catch (ScriptException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}