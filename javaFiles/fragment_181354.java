Instant i1 = new Instant(0);
Instant i2 = new Instant(72_345);
Duration d1 = new Duration(i1, i2);

Instant i3 = new Instant(60_000);
Instant i4 = new Instant(200_710);
Duration d2 = new Duration(i3, i4);

List<String> scoreTimes = new ArrayList<>();
scoreTimes.add(d1.toString());
scoreTimes.add(d2.toString());

// order from longest times to shortest times
Collections.sort(
    scoreTimes,
    new Comparator<String>() {

        @Override
        public int compare(String s1, String s2) {
            return Duration.parse(s2).compareTo(Duration.parse(s1));
        }
    }
);

System.out.println(scoreTimes); // [PT140.710S, PT72.345S]