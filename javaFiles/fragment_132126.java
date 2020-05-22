import javax.script.*

class Utils {
   void foo(String bar) {
      println bar
   }   
}

ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");

engine.eval("""
for(var fn in utils) {
  if(typeof utils[fn] === 'function') {
    this[fn] = (function() {
      var method = utils[fn];
      return function() {
         return method.apply(utils,arguments);
      };
    })();
  }
}

foo('foo'); // prints foo, sure enough
""",new SimpleBindings("utils":new Utils()))