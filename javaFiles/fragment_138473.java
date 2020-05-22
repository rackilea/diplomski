db.matrix.update(
{
    INSTITUTION_ID: 1,
    RuleID: 2,
},
{
    $pull:
    {
        Matrix:
        {
            Key:
            {
                $regex: /M$/
            }
        }
    }
})