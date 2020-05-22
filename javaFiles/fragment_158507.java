int i = 0;
while (i < list.size()) {
    ... any other computation you need to perform
    if ...you need to remove the element... {
        list.remove(i);
    } else {
        i++;
    }
}