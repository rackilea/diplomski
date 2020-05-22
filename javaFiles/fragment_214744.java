ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine jRubyEngine = manager.getEngineByName("jruby");
String s = "
  require 'rubygems'
  require 'rubygems/dependency_installer'
  Gem::DependencyInstaller.new.install('cucumber')
";
jRubyEngine.eval(s);