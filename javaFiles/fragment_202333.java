package hello_clj;

import clojure.lang.RT;
import clojure.lang.IFn;

public class Main {

    public String passBackMsg(String s) {
        return s;
    }

    public static void main(String[] args) {
        String script = "(do (import 'hello_clj.Main) (fn [s] " + 
                        "(.passBackMsg (Main.) s) ))";

        IFn fn = (IFn)RT.var("clojure.core", "eval").invoke(RT.var("clojure.core","read-string").invoke(script));
        System.out.print(fn.invoke("Hello"));
    }

}