// create the string with the insert statement
String sqlInsertString = "insert into online_orders_hdr ( " +
    " OOH_ONLINE_REFERENCE_NO, OOH_SERVICE_USER_ID, OOH_ORDER_STATUS, " +
    " OOH_TOTAL_QUANTITY, OOH_TOTAL_AMOUNT, OOH_PAYMENT_MODE, " +
    " OOH_SHIPPING_ID, OOH_SHIPPING_NAME, OOH_SHIPPING_ADDRESS1, " +
    " OOH_SHIPPING_ADDRESS2, OOH_SHIPPING_PLACE, OOH_SHIPPING_STATE, " + 
    " OOH_SHIPPING_COUNTRY, OOH_SHIPPING_PINCODE, OOH_SHIPPING_MOBILE, " + 
    " OOH_SHIPPING_PHONE, OOH_SHIPPING_EMAIL, OOH_CUSTOMER_ID, " +
    " OOH_CUSTOMER_NAME, OOH_CUSTOMER_ADDRESS_LINE1, " + 
    " OOH_CUSTOMER_ADDRESS_LINE2, OOH_CUSTOMER_CITY, OOH_CUSTOMER_STATE, " + 
    " OOH_CUSTOMER_PINCODE, OOH_CUSTOMER_COUNTRY, OOH_CUSTOMER_MOBILE, " +
    " OOH_CUSTOMER_EMAIL, OOH_POS_PUSH_STATUS, OOH_CREATED_AT, " + 
    " OOH_UPDATED_AT, OOH_POS_TIMESTAMP, OOH_ONLINE_PUSH_STATUS, " +
    " OOH_VENDOR) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

// prepare the statement
PreparedStatement insert = connection.prepareStatement(sqlInsertString);

// populate the statement variables
int i = 0;
insert.setString(++i, OOH_ONLINE_REFERENCE_NO);
insert.setString(++i, OOH_SERVICE_USER_ID);
insert.setString(++i, OOH_ORDER_STATUS);
insert.setString(++i, OOH_TOTAL_QUANTITY);
insert.setString(++i, OOH_TOTAL_AMOUNT);            
insert.setString(++i, OOH_PAYMENT_MODE);
insert.setString(++i, OOH_SHIPPING_ID);
insert.setString(++i, OOH_SHIPPING_NAME);
insert.setString(++i, OOH_SHIPPING_ADDRESS1);
insert.setString(++i, OOH_SHIPPING_ADDRESS2);
insert.setString(++i, OOH_SHIPPING_PLACE);
insert.setString(++i, OOH_SHIPPING_STATE);
insert.setString(++i, OOH_SHIPPING_COUNTRY);
insert.setString(++i, OOH_SHIPPING_PINCODE);
insert.setString(++i, OOH_SHIPPING_MOBILE);
insert.setString(++i, OOH_SHIPPING_PHONE);
insert.setString(++i, OOH_SHIPPING_EMAIL);
insert.setString(++i, OOH_CUSTOMER_ID);
insert.setString(++i, OOH_CUSTOMER_NAME);
insert.setString(++i, OOH_CUSTOMER_ADDRESS_LINE1);
insert.setString(++i, OOH_CUSTOMER_ADDRESS_LINE2);
insert.setString(++i, OOH_CUSTOMER_CITY);
insert.setString(++i, OOH_CUSTOMER_STATE);                
insert.setString(++i, OOH_CUSTOMER_PINCODE);
insert.setString(++i, OOH_CUSTOMER_COUNTRY);
insert.setString(++i, OOH_CUSTOMER_MOBILE);
insert.setString(++i, OOH_CUSTOMER_EMAIL);
insert.setString(++i, OOH_POS_PUSH_STATUS);
insert.setString(++i, OOH_CREATED_AT);
insert.setString(++i, OOH_UPDATED_AT);
insert.setString(++i, OOH_POS_TIMESTAMP);
insert.setString(++i, OOH_ONLINE_PUSH_STATUS);
insert.setString(++i, OOH_VENDOR);

// execute the insert statement
insert.executeUpdate();
connection.commit();