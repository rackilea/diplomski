StringBuilder builder = new StringBuilder();
for(int i = 0; i < count; i++){
    builder.append(x.charAt(i));
    builder.append(x.charAt(i>>4));
    builder.append(x.charAt(i>>8));
}

return builder.toString();