List<Object[]> list = 
    select CarId, LogDate dateOnly, sum(Gap)/1000 KM
    from CarLogDate
    where CarId IN
        (SELECT Id FROM car where ProjectId = 1)
    group by CarId, dateOnly;