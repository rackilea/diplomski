System.out.println(Arrays.deepToString(binaryTree.toArrayLevels()));

[[{60}], [{50}, {65}], [{49}, {55}, null, {66}], [null, null, null, null, null, null, null, {71}], [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null]]

[
    [{60}], // Level 0.
    [{50}, {65}], // Level 1.
    [{49}, {55}, null, {66}], // Level 2.
    [null, null, null, null, null, null, null, {71}], // Level 3.
    [null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null] // Level 4.
]