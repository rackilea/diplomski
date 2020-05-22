rule "set output"
when
    $s: Something(  $input: input )
    InToOut( input == $input, $output: output )
then
    modify( $s ){ setOutput( $output ) }
end