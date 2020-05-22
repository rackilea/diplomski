CREATE FUNCTION createDate(
  year   int,
  month  int,
  day    int,
  hour   int,
  minute int,
  second int
) RETURN DATE DETERMINISTIC
IS
  hex CHAR(14);
  d DATE;
BEGIN
  hex := TO_CHAR( FLOOR( year / 100 ) + 100, 'fm0X' )
      || TO_CHAR( MOD( year, 100 ) + 100, 'fm0X' )
      || TO_CHAR( month, 'fm0X' )
      || TO_CHAR( day, 'fm0X' )
      || TO_CHAR( hour + 1, 'fm0X' )
      || TO_CHAR( minute + 1, 'fm0X' )
      || TO_CHAR( second + 1, 'fm0X' );
  DBMS_OUTPUT.PUT_LINE( hex );
  DBMS_STATS.CONVERT_RAW_VALUE( HEXTORAW( hex ), d );
  RETURN d;
END;
/