function testAll($r, $tests) {
   foreach ($tests as $test) {
      $isMatch = preg_match($r, $test, $groups);
      $groupsJoined = join('|', $groups);
      print("$test $isMatch $groupsJoined\n");
   }
}

$tests = array('aaa', 'aaab', 'aaaxb', 'xaaab', 'b', 'abbb');

$r1 = '/^a+(?=b+)/';
#          └────┘
#         lookahead

testAll($r1, $tests);