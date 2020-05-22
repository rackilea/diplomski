String str = node.getNodeValue();
test = (test != null) ? test.toLowerCase() : null;
str = (str != null) ? str.toLowerCase() : "";
if (str.contains(test)) {
    i++;
}