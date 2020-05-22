public static void main(String[] args) {
    clojure("(defn fun[lst] (map #(/ % 2) lst))");
    clojure("(list* (#'clojure.core/fun '(1 2 3 4 5)))");
}

public static Object clojure(String s) {
    System.out.println("Evaluating Clojure code: " + s);
    Object result = mikera.cljutils.Clojure.eval(s);
    System.out.println("=> " + result);
    return result;
}