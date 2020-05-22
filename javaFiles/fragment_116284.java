select C.NAME,
       C.CLIENT_ID,
       AA.SEARCHES,
       (select count(1) 
          from RES_BOOKING R
          join CLI_WEB_USER U
            on U.ADM_USER_ID = R.BOOKED_USER
           and trunc(R.BOOKING_DATE) 
                between '01-MAR-16' 
                    and '24-MAR-16' 
           and U.CLIENT_ID = C.CLIENT_ID
        ) AS BOOKINGS
  from CLI_CLIENT C
  join 
       (select CWU.CLIENT_ID as CLIENT, 
               count(ST.OPERATION) AS SEARCHES 
          from STAT.ST_TRANSACTION ST 
          join CLI_WEB_USER CWU
            on CWU.USERNAME = ST.USER_NAME
          join CACHE.CACC_CRITERIA CC
            on CC.CRITERIA_ID = CS.CRITERIA_ID
          join CACHE.CACC_CRITERIA_STATS CS
            on CS.SESSION_ID = ST.SESSION_ID
         where ST.OPERATION like 'OTA_HotelAvailRQ%'
           and trunc(ST.TRS_TIMESTAMP) 
                between '01-MAR-16' 
                    and '24-MAR-16'
           and CWU.CLIENT_ID in (10975,10040)
           and CS.DISTRIBUTION_CHANNEL='W'
      group by CLIENT_ID, CLIENT -- OLD OF CLIENT -> CWU.CLIENT_ID
        ) AA
    on AA.CLIENT = C.CLIENT_ID; -- OLD OF AA.CLIENT -> AA.CLIENT_ID