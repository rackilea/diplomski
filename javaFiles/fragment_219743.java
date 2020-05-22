$pattern = <<<'EOD'
~
 (?(DEFINE)
     (?<neutral> (?: _ \g<neutral>?+ [A-Z] | [A-Z] \g<neutral>?+ _ )+ )
 )

 \A (?: \g<neutral> | _ )+ \z
~x
EOD;

var_dump(preg_match($pattern, '____ABC_DEF___'));