List<Integer> indexes = new ArrayList<Integer>();
for (int i = 0; i < types.length; i++) {
     indexes.add(i);
}
Collections.shuffle(indexes);

for (Integer index : indexes) {
    question.setText(types[index]);
    getAnswers(index);
    // Now do something else? It's unclear...
}