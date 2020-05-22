SELECT
    tzc.tzc_id,
    tzc.tz_id,
    tzc.offset_to_utc,
    FORMAT(tzc.start_time, 'dd-MM-yyyy HH:mm', 'en-US') start_time,
    FORMAT(tzc.end_time, 'dd-MM-yyyy HH:mm', 'en-US') end_time,
    tz.tz_code 
FROM timezone_conversion tzc
INNER JOIN timezone tz
    ON tzc.tz_id = tz.tz_id
ORDER BY
    tzc_id;