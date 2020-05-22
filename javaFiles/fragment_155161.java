SELECT a.SFCode, a.WarrantyCode, (a.QTY-b.QTY) AS Stock FROM
(SELECT SFCode, WarrantyCode, QTY
FROM Transactions_Table
WHERE SFCode = "12"
AND DocType IN ('FP','LP','CSR','CRR')
GROUP BY WarrantyCode) AS a 
LEFT JOIN
(SELECT SFCode, WarrantyCode, QTY
FROM Transactions_Table
WHERE SFCode = "12"
AND DocType IN ('FPR','LPR','CAS','CRS')
GROUP BY WarrantyCode) AS b
ON a.SFCode = b.SFCode AND a.WarrantyCode = b.WarrantyCode;