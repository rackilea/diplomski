MERGE INTO CustomerSpend WITH (HOLDLOCK) AS T 
USING ( SELECT ? AS ID, ? AS NetValue, ? AS VoidValue ) AS V 
ON T.ID = V.ID 
WHEN MATCHED THEN 
    UPDATE SET T.ID = V.ID, T.NetValue = T.NetValue + V.NetValue, T.VoidValue = T.VoidValue + V.VoidValue 
WHEN NOT MATCHED THEN 
    INSERT ( ID,NetValue,VoidValue ) VALUES ( V.ID, V.NetValue, V.VoidValue );