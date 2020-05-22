rule "challenge 2" salience 0
    when
        ClientTransaction()
    then
        challenge.setChallenge("challenge2");
end