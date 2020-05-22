// TODO: Compile this once and reuse
Pattern pattern = Pattern.compile("[^@]+@[^@]+");
Matcher matcher = pattern.matcher(valEmail);

if (!matcher.matches()) {
    ...
}