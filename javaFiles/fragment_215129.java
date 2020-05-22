SELECT  DISTINCT uniqueId
    FROM  advertisementmodule AS m 
    JOIN  advertisement AS a
          ON m.idAdvertisement = a.idAdvertisement
    JOIN  advertisementschedule AS s
          ON a.idAdvertisementSchedule = s.idAdvertisementSchedule
    JOIN  adschedulegroup AS g
          ON s.idAdScheduleGroup = g.idAdScheduleGroup
    WHERE  g.publisherCode = 'ABC';