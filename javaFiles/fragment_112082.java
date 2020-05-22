StudentAndSubjects sas = JsonUtils.safeEval(json);
Student student = sas.getStudent();
JsArray<Subject> subjects = sas.getSubjects();
for (int i = 0, l = subjects.length(); i < l; i++) {
  Subject subject = subjects.get(i);
  …
}