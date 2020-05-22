DROP TABLE IF EXISTS Calls;
DROP TABLE IF EXISTS SMS;
/*
        int number = Objects.requireNonNull(cursor).getColumnIndex("number");
        int type = cursor.getColumnIndex("type");
        int date = cursor.getColumnIndex("date");
        int duration = cursor.getColumnIndex("duration");
*/
CREATE TABLE IF NOT EXISTS Calls (number INTEGER, type INTEGER, date INTEGER, duration INTEGER);
/*
        int smsDate = Objects.requireNonNull(cursor1).getColumnIndexOrThrow(Telephony.Sms.DATE);
        int smsNumber = cursor1.getColumnIndexOrThrow(Telephony.Sms.ADDRESS);
        int smsType = cursor1.getColumnIndexOrThrow(Telephony.Sms.TYPE);
*/
CREATE TABLE IF NOT EXISTS SMS (address INTEGER, date INTEGER, type INTEGER);

INSERT INTO Calls VALUES
    (1000000001,100,strftime('%s','now','+1 minutes'),30),
    (1000000002,100,strftime('%s','now','+3 minutes'),30),
    (1000000003,100,strftime('%s','now','+4 minutes'),30),
    (1000000004,100,strftime('%s','now','+6 minutes'),30),
    (1000000005,100,strftime('%s','now','-7 minutes'),30)
;

INSERT INTO SMS VALUES
    (2000000011,strftime('%s','now','+2 minutes'),200) /* Should be between call 1 and call 2 */, 
    (2000000012,strftime('%s','now','-12 minutes'),200) /* Should be after call 1 (when sorted with DESC) */,
    (2000000013,strftime('%s','now','+5 minutes'),200) /* between call 3 and 4 */,
    (2000000014,strftime('%s','now','+6 minutes'),200) /* same as call4 ? may be before or after unless ORDER BY is more comprehensive */
;

SELECT *,datetime(date,'unixepoch') AS easytoreaddatetime FROM Calls;
SELECT *,datetime(date,'unixepoch') AS easytoreaddatetime FROM SMS;

/*<<<<<<<<<< THE QUERY >>>>>>>>>>*/
WITH combined AS (SELECT * FROM Calls UNION SELECT address, type, date, 0 FROM SMS)
SELECT *, datetime(date,'unixepoch') FROM combined ORDER BY date DESC;