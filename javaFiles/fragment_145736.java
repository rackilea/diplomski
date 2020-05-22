public static void main(String[] args) {
    Instant now = Instant.now();
    System.out.println(now);
    Instant truncated = now.truncatedTo(ChronoUnit.DAYS);
    System.out.println(truncated);
  }