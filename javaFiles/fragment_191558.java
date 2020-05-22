String[] arrayOfString;

Object[] arguments = new Object[arrayOfString.length + 2];
int argIndex = 0;
arguments[argIndex++] = "someString";
for (int i = 0; i < arrayOfString.length; i++) {
    arguments[argIndex++] = arrayOfString[i];
}
arguments[argIndex++] = "anotherString";

Formatter formatter = new Formatter();
formatter.format("FormatString", arguments);