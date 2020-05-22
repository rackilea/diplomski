SELECT year(o.day) as yyyy,
       month(o.day) as mm,
       SUM(oi.quantity * p.price) / COUNT(DISTINCT c.idCustomer) as avg_customer_spending,
       SUM(oi.quantity) as num_items
FROM customers c JOIN
     orders o
     ON c.idCustomer = o.Customer_idCustomer JOIN
     orderitem oi
     ON oi.Order_idOrder = o.idOrder JOIN
     product p
     ON oi.Product_idProduct = p.idProduct 
GROUP BY year(o.day), month(o.day);