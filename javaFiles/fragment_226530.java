StringBuilder regexBuilder = new StringBuilder("(");

for (int i = 0; i < names.size(); i++) {
    regexBuilder.append("(")
            .append(names.get(i))
            .append(")");
    if (i != names.size() - 1) regexBuilder.append("|");
}

regexBuilder.append(") ");
regexBuilder.append(regexBuilder);
regexBuilder.setLength(regexBuilder.length() - 1);


System.out.println(regexBuilder.toString());