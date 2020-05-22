function contains(set, object, key) {
    var solution = -1;
    set.forEach(function (item, index, array) {
        if (item[key] === object[key]) {
            solution = index;
        }
    });
    return solution;
}

function mergeSets(first, second, key) {
    var result = first;
    second.forEach(function (item, index, array) {
        var resultIndex = contains(result, item, key);
        if (resultIndex === -1) {
            result.push(item);
        } else {
            result[resultIndex].numPages = item.numPages;
            for (var property in item) {
                if (item.hasOwnProperty(property)) {
                    if (!result[resultIndex].hasOwnProperty(property)) {
                        result[resultIndex].property = item.property;
                    }
                }
            }
        }
    });
    return result;
}

var solution = mergeSets(firstSet, secondSet, "bookTitle");
console.log(solution);