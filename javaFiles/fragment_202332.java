String script = "(do                                    "+
                "  (import '(a.problem.domain Domain))  "+
                "  (fn [s]                " +
                "   (.passBackMsg (Domain.) s)               "+
                "))                                         ";

IFn fn = (IFn)RT.var("clojure.core", "eval").invoke(RT.var("clojure.core","read-string").invoke(script));

fn.invoke("hello");