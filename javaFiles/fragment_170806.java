groupByMonth = d3.nest()
    .key(function(d){return d.year; }) //NB: use "d.year", not "year"
    .key(function(d) {return d.month; }) // idem with month
    .rollup(function(v) { return d3.mean(v, function(d) { return d.TEST_DURATION; }); })
    .entries(data);
    })