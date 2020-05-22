UPDATE addressTable
   SET address_line1 = `<<new address line 1>>`,
       city = `<<new city>>`,
       state = `<<new state>>`,
       zip = `<<new zip>>`,
       version = version + 1
 WHERE address_id = `<<some key>>`
   AND version = `<<version you read initially>>`

IF( SQL%ROWCOUNT = 0 )
THEN
  -- Darn.  The row must have changed since you read it.  Do something to
  -- alert the user.  Most likely, the application will need to re-query the
  -- data to see what the address has been changed to and then ask the user
  -- whether they want to re-apply the changes.
  RAISE_APPLICATION_ERROR( -20001, 'Oops, the row has changed since you read it.' );
END IF;