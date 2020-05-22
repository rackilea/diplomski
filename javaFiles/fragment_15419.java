private List<String> validResponses() {
       List<String> responses = new ArrayList<>();
       values.add("Yes");
       values.add("Agree")
       values.add("No");
       values.add("Disagree");
       return Collections.unmodifiableList(responses);
 }