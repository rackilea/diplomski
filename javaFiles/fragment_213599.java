Person foo = null;
for (Person p : list) {
    if (p.getName().equals("joe")) {
        foo = p;
        break;
    }
}
// now foo is your person (if he exists) or null (if he doesnt exist);