import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

ScriptEngine jsRuntime = new ScriptEngineManager().getEngineByName("javascript");
String expression = "2+2"; //The expression you would to evaluate.
double result = (Double) jsRuntime.eval(expression);