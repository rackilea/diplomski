function contains(set, object) {
    var solution = -1;
    set.forEach(function (item, index, array) {
        if (item.bookTitle == object.bookTitle && item.author == object.author) {
            solution = index;
        }
    });
    return solution;
}