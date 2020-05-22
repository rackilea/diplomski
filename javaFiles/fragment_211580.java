rule calculate
when 
    $c: Contract( $cs: clientSex, $ca: clientAge,
                  $pc: professionCode, $py: policyYear,...
                  ...
                  $si: sumInsured )

    PxRow( gender == $cs, age == $ca, $px: px )
    PyRow( profCode == $pc, polYear == $py,... $py: py )
    PzRow( ... $pz: pz )
then
    double premium = $si * $px * (1 + $py) / $pz; 
    // round to 2 digits 
    modify( $c ){ setPremium( premium ) }
end