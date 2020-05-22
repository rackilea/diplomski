rule "Fourth Test"
when
    $V1: Account( $sta: status == "Inactive" )
    or
    ($V1: Account( $sta: status == "Active" )
    and
    Insurance( currentInd == "N" ) from $V1.getInsurance()
    )
then
    System.out.println("Fourth Test " + $V1.getId() );
end