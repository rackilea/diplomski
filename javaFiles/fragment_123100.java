rule "BigAmount"
    dialect "mvel"
    when
        f : Transaction( amount >= 10000 )
    then
        f.addActivatedRule( "BigAmount" );
end