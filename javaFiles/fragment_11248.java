private String generateCode(Information info) {
  StringBuilder code = new StringBuilder();
  code.append(getClassCode(info.getMotherClass()));
  code.append(newLine());
  code.append(tab());
  code.append(getConstructor(info));
  return code.toString();
}

public static String getClassCode(String className){
  StringBuilder code = new StringBuilder();
  code.append("public class ");
  if (!removeSpaces(className).isEmpty()){
    code.append(className);  
  } else {
    code.append(Information.getDefaultClass());//have a default static name for a class like "Application"
  }
  code.append("{");
  code.append(newLine());
  return code.toString();
}

public static String getConstructor(Information info){
  StringBuilder code = new StringBuilder();
  if(!info.isGenerateDefaultConstructor()) {
    code.append("public ");
    code.append(info.getMotherClass());
    code.append("(){");
    code.append(newLine());
    code.append(tab());
    code.append(info.getConstructorContent());//what will be in the constructor
    code.append(newLine());
    code.append(tab());
    code.append("}");
  }
  code.append(newLine());
  return code.toString();
}