$ java -XX:CompileCommand=help
  CompileCommand and the CompilerOracle allows simple control over
  what's allowed to be compiled.  The standard supported directives
  are exclude and compileonly.  The exclude directive stops a method
  from being compiled and compileonly excludes all methods except for
  the ones mentioned by compileonly directives.  The basic form of
  all commands is a command name followed by the name of the method
  in one of two forms: the standard class file format as in
  class/name.methodName or the PrintCompilation format
  class.name::methodName.  The method name can optionally be followed
  by a space then the signature of the method in the class file
  format.  Otherwise the directive applies to all methods with the
  same name and class regardless of signature.  Leading and trailing
  *'s in the class and/or method name allows a small amount of
  wildcarding.  

  Examples:

  exclude java/lang/StringBuffer.append
  compileonly java/lang/StringBuffer.toString ()Ljava/lang/String;
  exclude java/lang/String*.*
  exclude *.toString