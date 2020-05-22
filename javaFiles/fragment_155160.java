SELECT SFCode, SUM(FP+LP+CSR+CRR-FPR-LPR-CAS-CRS) AS Total FROM
(SELECT SFCode,
SUM(IF(DocType = "FP", QTY, 0)) AS FP,
>>please fill out all the columns<<    
FROM Transactions_Table
WHERE SFCode = "12"
GROUP BY DocType);