$(function() {
    var input = [
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    ];

    var count = 0;

    function main() {
        var row = 0, col = 0;
        apply(row, col);
        console.log(count);
    };

    function apply(x, y) {
        var currentColor = getValueAt(x, y);
        if (currentColor == 0) {
            visit(x, y);
            count++;
            apply(x + 1, y + 1);
            apply(x + 1, y);
            apply(x, y + 1);
        }
    }

    function getValueAt(x, y) {
        if (x < 0 || y < 0 || x >= input.length || y >= input[x].length) {
            return -1;
        } else {
            return input[x][y];
        }
    }

    function visit(x, y) {
        setTimeout(function() {
           $(("#child" + x) + y).css("background-color", "pink");
        }, 170 * x + 170 * y);
        input[x][y] = 1;
    }

    function visualize() {
        for (var i = 0; i < input.length; i++) {
            $("<div />", {
                "id" : "row" + i
            }).appendTo("#parent");

            for (var j = 0; j < input[i].length; j++) {

                $("<div />", {
                    "class" : "child",
                    "id" : ("child" + i) + j
                }).appendTo("#row" + i);
            }
        }
    }

    visualize();
    main();
});