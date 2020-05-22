rule "find best BaseUpChargeConfig"
when
// pick up some PricingLineItem
$pli: PricingLineItem( $prefix: prefix, $ackId : ackId )
// it should have a BaseUpChargeConfig with a matching prefix
$bucc: BaseUpChargeConfig( prefix == $prefix,
                           $baseOptionId : baseOptionId )
// count BaseOptionConfigs (linked to BaseUpChargeConfig) matching
// PricingOptionTypes, by option id/code and option value
accumulate(
    BaseOptionConfig( id == $baseOptionId,
                      $ocod: bOptionCode, $oval: bOptionValue )
    and          
    PricingOptionType( ackId == $ackId,
                       optionId == $ocod, optionValue == $oval );
      $count: count(1) )

// The $count computed above is the maximum if we don't have another
// BaseUpChargeConfig (for that prefix) where the count of the
// subordinate BaseOptionConfigs is greater than $count
not(
    ( BaseUpChargeConfig( this != $bucc,
                          prefix == $prefix,
                          $baseOptionId2 : baseOptionId )
      and
      accumulate(
          BaseOptionConfig( id == $baseOptionId2,
                            $ocod2: bOptionCode, $oval2: bOptionValue )
          and            
          PricingOptionType( ackId == $ackId,
                             optionId == $ocod2, optionValue == $oval2);
      $count2: count(1);
      $count2 > $count ) ) )
then
    System.out.println( "best BaseUpChargeConfig: " + $baseOptionId );
end