while(options.size() > 0) {
    int index = rnd.nextInt(options.size());
    ...
    options.remove(index);
}
...
updateAnswers(options);