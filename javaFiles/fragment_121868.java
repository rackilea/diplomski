String filterPath = "aa.bb.cc{k1:v1,k2:{s1:s2}},bb.cc,ee.dd";

List<String> result = new ArrayList<String>();
StringBuilder build = new StringBuilder();
int skip = 0;

for (char c : filterPath.toCharArray()) {
    if (c == ',' && skip == 0) {
        result.add(build.toString());
        build = new StringBuilder();
        continue;
    }

    if (c == '{') {
        skip++;
    } else if (c == '}') {
        skip--;
    }

    build.append(c);
}

result.add(build.toString());

for (String r : result) {
    System.out.println(r);
}