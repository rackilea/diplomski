// function used to make display prettier
function zeroPadLeft(str, len) {
    while (str.length < len) {
        str = "0" + str;
    }
    return str;
}

function compareBits(num1, num2) {
    // score is the number of matching bits
    var score = 0;
    // start with first bit
    var mask = 1;
    // create rotating mask to individually compare each of the lowest 32 bits
    for (var i = 0; i < 32; i++) {
        // if this bit has the same value, increase the score
        if ((num1 & mask) === (num2 & mask)) {
            ++score;
        }
        // advance mask to next bit with shift left operator
        mask = mask << 1;
    }
    return score;
}

// input data
var data = [
    {name:"Danniel", value:116077289}, 
    {name:"Bowman", value:2316887705}, 
    {name:"Cleveland", value:2186347654}, 
    {name:"Marinda", value:2662238982}, 
    {name:"Viviana", value:3393681530}
];

// show the starting data in binary so we can see a visual representation of the actual bits
log("<b>Visually in Binary</b>");
data.forEach(function (item) {
    log(zeroPadLeft(item.value.toString(2), 32) + "  " + item.name);
});

// record the score of all possible combinations in the scores array of objects
log("<hr>");
log("<b>All Comparisons</b>");
var scores = [];
for (var j = 0; j < data.length; j++) {
    for (var k = j + 1; k < data.length; k++) {
        var score = compareBits(data[j].value, data[k].value);
        // record the score and two names as an object inserted into an array
        scores.push({
            name1: data[j].name,
            name2: data[k].name,
            score: score
        })
    }
}

// sort by best score to make it easier to find the highest score
scores.sort(function (a, b) {
    return b.score - a.score;
});
// output sorted scores so we can see them visually
scores.forEach(function (item) {
    log(item.name1 + "," + item.name2 + ":" + item.score);
});

// now find the top scores with no person repeated
log("<hr>");
log("<b>Best Matches</b>");
// namesUsed keeps track of which names have already found a high score so we don't use them again
var namesUsed = {};
while (scores.length > 0) {
    var bestItem = scores.shift();
    // if either of these names has already been used, then skip this score
    if (namesUsed[bestItem.name1] || namesUsed[bestItem.name2]) {
        continue;
    }
    log(bestItem.name1 + "," + bestItem.name2 + ": " + bestItem.score);
    namesUsed[bestItem.name1] = true;
    namesUsed[bestItem.name2] = true;
}