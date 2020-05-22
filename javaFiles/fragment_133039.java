ALTER TABLE pay -- <<-- maybe here ???
  ADD CONSTRAINT foranea_pay_customer
   FOREIGN KEY (customerid)
    REFERENCES customer (customerid)
     ON UPDATE CASCADE ON DELETE SET NULL
  ;