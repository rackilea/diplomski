rule "BigAmount"
    dialect "mvel"
    when
        Transaction( amount > 10000.0 )
    then
        Transaction fact0 = new Transaction();
        fact0.setActivatedRule( "BigAmount" );
        insert( fact0 );
end