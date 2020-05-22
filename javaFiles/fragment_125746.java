package lv.test;

import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MyClass {
    private int field;

    public int getField() {
        return field;
    }

    public void setField(final int field) {
        this.field = field;
    }

    public String toString() {
        return String.format("{%d}", field);
    }

    public static void main(String[] args) throws ScriptException {
        final ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine e = manager.getEngineByName("js");

        final Bindings b = e.getBindings(ScriptContext.ENGINE_SCOPE);

        final List<MyClass> somelist = new ArrayList<MyClass>();
        somelist.add(new MyClass());

        b.put("somelist", somelist);

        final StringBuilder script = new StringBuilder()
            .append("function abc(x,y) { return x+y+new java.lang.Integer(2).intValue(); }")
            .append("somelist.get(0).setField(abc(2,3));")
            .append("somelist.add(new Packages.lv.test.MyClass()); somelist.get(1).setField(888);");

        e.eval(script.toString());

        System.out.println(somelist); // [{7}, {888}]
    }
}