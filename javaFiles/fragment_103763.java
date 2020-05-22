int count = 0;
Set<String> set1 = new HashSet<String>(LabUtils.getWordsFromFile(f1));
Set<String> set2 = new HashSet<String>(LabUtils.getWordsFromFile(f2));

Iterator<String> it = set1.iterator();

while (it.hasNext()){
    String s = it.next();

    if (set2.contains(s)){
        count++;
    }

}