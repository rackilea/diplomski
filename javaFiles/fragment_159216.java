Formatter formatter = new Formatter();
formatter.format("Hello, world\n");
if (name != null) {
    formatter.format("My name is %s\n", name);
} else {
    formatter.format("Please email me at %s\n", email);
}
doUse(formatter.toString();