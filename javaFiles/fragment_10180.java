SELECT c.account_id as client_account_id,
       c.client_code, 
       a.account_id as shipping_account_id
       a.address_code
FROM CLIENT c LEFT JOIN
     ADDRESS a 
     ON a.address_code = c.shipping_address_code AND 
        a.account_id = c.account_id
WHERE c.account_id = 4;