function contains(set, object, keys) {
    var solution = -1;
    set.forEach(function (item, index, array) {
        var selfItem = item;
        var allKeys = keys.every(function (item, index, array) {
            if (selfItem[item] === object[item]) {
                return true;
            }
        });
        if (allKeys) {
            solution = index;
        }
    });
    return solution;
}

function mergeSets(first, second) {
    var result = first;
    var keys = Array.prototype.slice.call(arguments, 2);
    second.forEach(function (item, index, array) {
        var resultIndex = contains(result, item, keys);
        if (resultIndex === -1) {
            result.push(item);
        } else {
            for (var property in item) {
                if (item.hasOwnProperty(property)) {
                    if (!result[resultIndex].hasOwnProperty(property)) {
                        var hello = result[resultIndex];
                        hello[property] = item[property];
                    }
                }
            }
        }
    });
    return result;
}

var solution = mergeSets(firstSet, secondSet, "bookTitle", "author");
console.log(solution);