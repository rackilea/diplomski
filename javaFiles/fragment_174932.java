TreeIterator<String> iterator = new TreeIterator<>(rootItem);
int nItems = 0;
while (iterator.hasNext()) {
    nItems++;
    iterator.next();
}