select C.NAME,
       C.CLIENT_ID,
       (select count(1) 
          from RES_BOOKING R
          join CLI_WEB_USER U
            on U.ADM_USER_ID = R.BOOKED_USER
           and trunc(R.BOOKING_DATE) 
                between '01-MAR-16' 
                    and '24-MAR-16' 
           and U.CLIENT_ID = C.CLIENT_ID
        ) AS BOOKINGS
  from CLI_CLIENT C;