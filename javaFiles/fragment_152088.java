public List<String> findPathOfName(String nameToFind) {
    List<String> result = new ArrayList<String>();

    if (nameToFind.equals(name)) {
      result.add(name);
    } else {
      for (MyClass aSubClass: subClasses) {
        List<String> subResult = aSubClass.findPathOfName(nameToFind);
        if (!subResult.isEmpty()) {
           result.add(name);
           result.addAll(subResult);
           break;
        }
      }
    }

    return result;
}