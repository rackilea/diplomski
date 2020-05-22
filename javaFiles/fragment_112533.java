ScriptEngine INTERPRETER = new ScriptEngineManager().getEngineByName("js")
String scriptText = "";
FileReader fr = null;
BufferedReader br = null;
try {
    fr = new FileReader(new File(script));
    br = new BufferedReader(fr);

    String currentLine;
    while((currentLine = br.readLine()) != null)
        scriptText += currentLine;

} catch (IOException e) {
    System.err.println("Script " + script + " not found");          
}
ScriptObjectMirror obj = null;

try {
    obj = (ScriptObjectMirror) INTERPRETER.eval(scriptText);
} catch (Exception e) {
    e.printStackTrace();
}

return obj.to(String[].class);