.executeUpdate("
MERGE INTO tblStates AS Target
USING (VALUES ('"+ statecode + "','" + statename + "'))
       AS Source (StateCode, StateName)
ON Target.StateCode = Source.StateCode
WHEN NOT MATCHED BY TARGET THEN
    INSERT (StateCode, StateName) VALUES ('"+ statecode + "','" + statename + "');
)";