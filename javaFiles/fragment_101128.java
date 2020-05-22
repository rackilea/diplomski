Map<Trial, Integer> challenge = new EnumMap<Trial, Integer>(Trial.class);
int t = 4 + random.nextInt(5);
// collect all Trial values in a list
List<Trial> allTrials = Arrays.asList(Trial.values());
// shuffle that list
Collections.shuffle(allTrials);
// select the number of trials we want, add them to challenge
for (int i = 0; i < t; ++i) {
  challenge.put(allTrials.get(i), random.nextInt(100) + 25);
}

// example output: {DRIVE=121, WEAPONS=119, STRATEGY=59, HACKING=78, STEALTH=72}
System.out.println(challenge);