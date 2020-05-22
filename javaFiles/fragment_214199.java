$.each(data, function(key, value) {
  dataPoints.push({
    label: value[Object.keys(value)[0]],
    y: value[Object.keys(value)[1]]
  });
});