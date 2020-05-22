public String toString() {
    String results = "+";
    for(Dog d : dogList) {
        results += d.toString(); //if you implement toString() for Dog then it will be added here
    }
    return results;
  }
}