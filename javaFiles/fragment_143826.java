rule "Third Test A"
when
    $V1: Account( $sta: status == "Inactive" )
then
    System.out.println("Third Test A " + $V1.getId() );
end
rule "Third Test B"
when
    $V1: Account( $sta: status == "Active" )
    Insurance( currentInd == "N" ) from $V1.getInsurance()
then
    System.out.println("Third Test B " + $V1.getId() );
end