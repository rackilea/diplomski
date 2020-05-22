String encloseInSquareBrackets(String pattern) {
  return "\[" + pattern + "]";
}

...
String pattern = "/abc/def" + encloseInSquareBrackets("\d")+ "/ghi";