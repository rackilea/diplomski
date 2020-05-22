String scriptPath = "/path/to/my/javascripts/"; // indesign server needs file access to this folder
VariableType file = VariableTypeUtils.createFile(scriptPath);

// ScriptLanguage.UNKNOWN - 1433299822
// ScriptLanguage.APPLESCRIPT_LANGUAGE - 1095978087
// ScriptLanguage.JAVASCRIPT - 1246973031

// do javascript
OptScriptLanguageEnum scriptType = OptArg.makeScriptLanguageEnum(1246973031);

// add values ...
VariableType[] params = new VariableType[1];
params[0] = VariableTypeUtils.createBoolean(true);
OptVariableTypeSeq args = OptArg.makeVariableTypeSeq(params);

// or if you got no args
args = OptArg.noVariableTypeSeq();

// undo modes
OptUndoModesEnum undoModes = OptArg.noUndoModesEnum();
// string to undo mode
OptString undoName = OptArg.noString();

// add to application
VariableType vt = gApp.doScript(file, scriptType, args, undoModes, undoName);