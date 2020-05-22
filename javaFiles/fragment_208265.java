function mergeSets(first, second) {
    var result = first;
    second.forEach(function (item, index, array) {
        var resultIndex = contains(result, item);
        if (resultIndex === -1) {
            result.push(item);
        } else {
            result[resultIndex].numPages = item.numPages;
        }
    });
    return result;
}