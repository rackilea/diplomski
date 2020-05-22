$tests = array(
  'aaa', 'aaab', 'aaaxb', 'xaaab', 'b', 'abbb', 'aabb', 'aaabbbbb', 'aaaaabbb'
);

$r4 = '/ ^ (?: a (?= a* (\1? b) ) )+ /x';
#          │     │      └─────┘ | │
#          │     │         1    | │
#          │     └──────────────┘ │
#          │         lookahead    │
#          └──────────────────────┘
#             non-capturing group