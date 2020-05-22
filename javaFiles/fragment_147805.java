Set<Integer> s = new HashSet<>();
//correct value
s.add(value);
while (s.size() < 4)
{
    //incorrect value
    s.add( value + rand.nextInt(10) + 1);
}
List<Integer> answers = new ArrayList<>(s);
//shuffle
Collections.shuffle(answers);