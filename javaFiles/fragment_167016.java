$r2 = '/ ^ a+ (?= (b+) ) /x';
#             │   └──┘ │
#             │     1  │
#             └────────┘
#              lookahead

testAll($r2, $tests);