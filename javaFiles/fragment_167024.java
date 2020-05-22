$tests = array(
  'aaa', 'aaab', 'aaaxb', 'xaaab', 'b', 'abbb', 'aabb', 'aaabbbbb', 'aaaaabbb',
  '', 'ab', 'abb', 'aab', 'aaaabb', 'aaabbb', 'bbbaaa', 'ababab', 'abc',
  str_repeat('a', 5000).str_repeat('b', 5000)
);

$r6 = '/ ^ (?: a (?= a* (\1?+ b) ) )+ \1 $ /x';
#          │     │      └──────┘ │ │
#          │     │          1    │ │
#          │     └───────────────┘ │
#          │         lookahead     │
#          └───────────────────────┘
#             non-capturing group