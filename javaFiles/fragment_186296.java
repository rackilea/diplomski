for (Iterator<String> iterator = personalNames.iterator(); iterator.hasNext(); ) {
    String name = iterator.next();
    if (isErrorProne(name)) {
        iterator.remove();
    }
}