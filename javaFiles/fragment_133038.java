ALTER TABLE
  ADD CONSTRAINT pay foranea_pay_customer -- <<-- one token too many here
   FOREIGN KEY (customerid)
    REFERENCES customer (customerid)
     ON UPDATE CASCADE ON DELETE SET NULL
  ;