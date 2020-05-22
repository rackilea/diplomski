rule "calc age/stage bonus"
when 
    $p: Player( age < 16, stage > 2 )
then
    modify( $p ){ setBonus( $p.getBonus)() + 30 ) }
end