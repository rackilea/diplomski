package de.scrum_master.stackoverflow;

import java.io.IOException;
import java.io.InputStream;

import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public class MethodDisassembler {
  public static void main(String[] args) throws IOException {
    Class<?> clazz = MethodDisassembler.class;
    String classAsPath = clazz.getName().replace('.', '/') + ".class";
    try (InputStream classStream = clazz.getClassLoader().getResourceAsStream(classAsPath)) {
      ClassParser classParser = new ClassParser(classStream, classAsPath);
      JavaClass javaClass = classParser.parse();
      for (Method method : javaClass.getMethods())
        System.out.println(method.getCode());
    }
  }

  public void doSomething() {
    sendEmail();
  }

  public void sendEmail() {
    System.out.println("Sending e-mail");
  }
}