rule "check 7 days limit"
when
    $t: Transaction( $orgId: organisationId,
                     $transT: transactionTime,
                     amount > 0, status == Status.VALID )
    AccountSums( organisationId == $orgId,
                 lastTransactionTime == $transT,
                 runningWeeklySum > 1000000 )
then
    modify( $t ){ setStatus( Status.INVALId ) }
end

rule "create AccountSums"
when
    $t: Transaction( $orgId: organisationId,
                     amount > 0 )
    not AccountSums( organisationId == $orgId )
then
    insert( new AccountSums( $orgId ) );
end