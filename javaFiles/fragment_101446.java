function mapByPattern(data, pattern, offset) {
    var result = [], i = 0;
    while (i < data.length) {
        result.push(pattern.map(j => data[i + j]));
        i += offset;
    }
    return result;
}

var data = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11],
    result = { series: [
        { name: 'Temperature', data: mapByPattern(data, [0, 1], 3) },
        { name: "Humidity",    data: mapByPattern(data, [0, 2], 3) }
    ]};

console.log(result);