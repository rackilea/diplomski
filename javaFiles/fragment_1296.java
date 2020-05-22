String[] tests = {
       "Test:mail",
       "Test\":\"mail",
       "Test\"ll",
       ".\".",
       "foo\"\"\""
};

String re = "(.*(?<=\")[.\\x20(),:;<>@\\[\\]\"](?=\").*)+";

int len=tests.length;
for(int i=0; i<len;i++) {
    System.out.format("Test %d: %s >> %s\n" , i+1, tests[i], tests[i].matches(re));
}