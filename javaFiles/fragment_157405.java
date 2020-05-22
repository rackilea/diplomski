MessageList annotation = element.getAnnotation(MessageList.class);
String locals = annotation.value();

// To get the package name, I used a while loop with an empty body. Does its job just fine.
Element enclosingElement = element;
while (!((enclosingElement = enclosingElement.getEnclosingElement()) instanceof PackageElement)) ;
String packageName = ((PackageElement) enclosingElement).getQualifiedName().toString();

ArrayList<Message> messages = new ArrayList<>();
for (Field field : annotatedClass.getDeclaredFields()) {
    if (!field.isEnumConstant()) continue;

    // Enum constants are static:
    Object value = field.get(null);
    MessageInfo messageInfo = messageInfoClass.cast(value);

    messages.add(new Message(field.getName(), messageInfo.getKey(), messageInfo.getParams()));
}