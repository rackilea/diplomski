Iterator<Choice> iterator = option.choices.iterator(); // or use option.choices.listIterator()

while (iterator.hasNext()) {
    if (emptyChoice.equals(iterator.next())) {
        iterator.remove();
    }
}