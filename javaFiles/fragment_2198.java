Iterator<Properties> it = propertiesList.iterator();
while (it.hasNext()) {
    if (it.next().getKey().equals(keyToDelete)) {
        it.remove();
    }
}