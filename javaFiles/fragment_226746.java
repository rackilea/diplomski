package org.mathjs;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathJSDemo {
    protected static String MATHJS_URL = 
            "http://cdnjs.cloudflare.com/ajax/libs/mathjs/1.0.1/math.js";

    protected ScriptEngine engine;

    public MathJSDemo() throws MalformedURLException, ScriptException, IOException {
        ScriptEngineManager manager = new ScriptEngineManager ();
        engine = manager.getEngineByName ("js");

        engine.eval(new InputStreamReader(new URL(MATHJS_URL).openStream()));
        engine.eval("var parser = math.parser();");
        engine.eval("var precision = 14;");
    }

    public String eval (String expr) throws ScriptException {
        String script = "math.format(parser.eval('" + expr + "'), precision);";
        return (String) engine.eval(script);
    }

    public static void main(String[] args) throws ScriptException, MalformedURLException, IOException {
        MathJSUrl math = new MathJSDemo();
        System.out.println(math.eval("a = 4.5"));
        System.out.println(math.eval("1.2 * (2 + a)"));
        System.out.println(math.eval("5.08 cm in inch"));
        System.out.println(math.eval("sin(45 deg) ^ 2"));   
        System.out.println(math.eval("9 / 3 + 2i"));    
        System.out.println(math.eval("det([-1, 2; 3, 1])"));
    }
}