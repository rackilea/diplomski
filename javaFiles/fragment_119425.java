private void getAllWordHelpers(List<String> list, DictionaryWord current) {
    if (current != null) {
        getAllWordHelpers(list, current.getLeftChild());
        list.add(current.getWord());
        getAllWordHelpers(list, current.getRightChild());
    }
}