String[] extraWithDescription = new String[extra.length + 1];
int i = 0;
for(; i < extra.length; ++i) {
  extraWithDescription[i] = extra[i];
}
extraWithDescription[i] = description;
getObject(find_arguments, extraWithDescription);