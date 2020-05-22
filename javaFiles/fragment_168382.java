<?php
$regex = "/@test\\s+([:.\\w\\\\x7f-\\xff]+)(?:[\\t ]+(\\S*))?(?:[\\t ]+(\\S*))?\\s*$/m";
$s1 = "    /**\n     * @test     TestGroup\n     */\n";
$s2 = "foo @test : bar baz";

preg_match($regex, $s1, $matches);
for ($i = 0; $i < count($matches); $i++) {
    echo "Match $i: $matches[$i]\n";
}
echo "\n";

preg_match($regex, $s2, $matches);
for ($i = 0; $i < count($matches); $i++) {
    echo "Match $i: $matches[$i]\n";
}
?>