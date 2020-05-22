import javax.script.*

manager = new ScriptEngineManager()
engine = manager.getEngineByName("JavaScript")

javascriptString = """
obj = {"value" : 42}
print(obj["value"])
"""

engine.eval(javascriptString)  // prints 42