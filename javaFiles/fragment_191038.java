StringBuffer sourceCode = new StringBuffer();
sourceCode.append("package org.mdkt;\n");
sourceCode.append("public class HelloClass {\n");
sourceCode.append("   public String hello() { return \"hello\"; }");
sourceCode.append("}");

Class<?> helloClass = InMemoryJavaCompiler.compile("org.mdkt.HelloClass", sourceCode.toString());