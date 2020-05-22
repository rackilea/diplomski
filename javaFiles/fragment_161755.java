// ASSERTION: parts.length % 4 == 0
Person[] people = new Person[parts.length / 4];
int peopleIndex = 0;
for (int i = 0; i < parts.length; i += 4) {
    people[peopleIndex++] = new Person(parts[i], parts[i + 1], parts[i + 2], parts[i + 3]);
}