StringBuilder sb = new StringBuilder();
Random random = new Random();
for (int i = 0; i < 4; ++i) {
  sb.append(adverbs.get(random.nextInt(4)) + " ");
  sb.append(adjectives.get(random.nextInt(4)) + " ");
  sb.append(nouns.get((random.nextInt(4)) + " ");
  sb.append(verbs.get((random.nextInt(4)) + "\n");
}