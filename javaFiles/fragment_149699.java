String magicQuery ="SELECT * FROM 
                     (SELECT * 
                      FROM Notifications 
                      Where TypeNotification <> 'Event' 
                      UNION 
                      SELECT * 
                      FROM NotificationsCron) T 
                   ORDER BY SUBSTR(DATE('NOW'), 0)>SUBSTR(DateToNotify, 0), SUBSTR(DateToNotify, 0)";