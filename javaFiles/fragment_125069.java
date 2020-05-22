@Override
public String toString() {

String str = "";
str = "CyclicEmployee{" +
    "age=" + age +
    ", name='" + name + '\'';
if (boss != null) {
  str += ", boss=" + boss;
}
if (subordinate.size() != 0) {
  str += ", subordinate=" + subordinate;
}
  str += '}';
return str;
}