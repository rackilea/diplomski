rule "Transaction situation exists"
    when
        trn: TransactionEvent()

        // some `trn` related statements

        $optionalData : // bind as wanted

        not ConfirmEvent (
            processMessageId == trn.groupId )
    then
        InferredFact $inferredFact = new InferredFact($optionalData);
        insertLogical($inferredFact);
end

rule "Rule 1"
    when
        InferredFact()
        AdditionalCondition()
    then
        // some actions
end

rule "Rule 2"
    when
        InferredFact()
        OtherCondition()
    then
        // some other actions
end