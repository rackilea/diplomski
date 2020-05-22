rule "calc age/stage bonus"
when 
    $p: Player( age < 16, stage > 2, bonusAgeStage == 0 )
then
    modify( $p ){ setBonusAgeStage( 30 ) }
end