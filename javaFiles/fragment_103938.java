class Test {
  public static void main(String[] args) {
    Map<String, Predicate<Integer>> gradingSystem = new HashMap<>();

    gradingSystem.put("A", mark -> mark >= 90 && mark <= 100);
    gradingSystem.put("B", mark -> mark >= 80 && mark < 90);

    translateScoreIntoGrade(86, gradingSystem); // B
    translateScoreIntoGrade(95, gradingSystem); // A
  }

  public static String translateScoreIntoGrade(int score, Map<String, Predicate<Integer>> gradingSystem) {
    return gradingSystem.entrySet().stream()
        .filter(gradePredicate -> gradePredicate.getValue().test(score))
        .findFirst()
        .map(Map.Entry::getKey)
        .orElseThrow(() -> new IllegalArgumentException("This grade isn't valid for this system!"));
  }
}