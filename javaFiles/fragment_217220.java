boolean first = true;
StringBuilder builder = new StringBuilder();

for (Map.Entry<MyClass.Key,String> entry : data.entrySet()) {
    if (first) {
        first = false;
    } else {
        builder.append("\n"); // Or whatever break you want
    }
    builder.append(entry.key())
           .append(": ")
           .append(entry.value());
}