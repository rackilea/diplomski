String s = "The patient is currently being treated for Diabetes with Thiazide diuretics";

Matcher m = Pattern.compile("\\b(?:Thiazide diuretics)\\b|\\S+").matcher(s);
ArrayList<String> result = new ArrayList<>();
while (m.find()) {
    result.add(m.group());
}
System.out.println(result);
// [The, patient, is, currently, being, treated, for, Diabetes, with, Thiazide diuretics]