public virtual ICriteria BuildCriteria(ICriteria criteria)
{
    foreach (SheCriterion criterion in this.SheCriterions)
    {
        criteria.Add(criterion.BuildCriterion());
    }

    return criteria;
}

public virtual ICriterion BuildCriterion()
{
    if (OperatorKey == "OR")
    {
        return new Disjunction()
            .Add(Left.BuildCriterion())
            .Add(right.BuildCriterion());
    }
    else
    {
        return new Conjunction()
            .Add(Left.BuildCriterion())
            .Add(right.BuildCriterion());
    }
}