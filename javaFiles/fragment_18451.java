SELECT i.issue_id, i.issue_description,
       it.tracker_status, it.tracked_time
FROM issues i 
LEFT JOIN ( SELECT it.issue_id, it.tracker_status, it.tracked_time 
            FROM issue_tracker it 
            INNER JOIN (SELECT issue_id, MAX(tracked_time) tracked_time 
                        FROM issue_tracker GROUP BY issue_id
                       ) A ON it.issue_id = A.issue_id AND it.tracked_time = A.tracked_time 
          ) it ON i.issue_id = it.issue_id 
WHERE i.status = "Escalate To";