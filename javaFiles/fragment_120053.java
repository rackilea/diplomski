DELIMITER ;;
  CREATE EVENT UpdateData ON SCHEDULE EVERY DAY STARTS '2016-10-10 00:00:00' -- This is scheduled to start from '2016-10-10' and updates data every day
  DO BEGIN
    UPDATE table1 SET Status = 1 WHERE Status = 0;
    UPDATE table2 SET Status = 1 WHERE Status = 0;
  END;;
DELIMITER ;