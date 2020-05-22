rule "setInToOut"
salience 999999999
when
then
    insert( new InToOut( "A", 0.1 ) );
    insert( new InToOut( "B", 0.2 ) );
     ...
end