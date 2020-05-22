-- Drop tables and triggers (allows rerunability for testing)
DROP TABLE IF EXISTS OperationEntry;
DROP TABLE IF EXISTS OperationEntryChanges;
DROP TRIGGER IF EXISTS OperationEntryTrigger;

-- Create the original/core table
CREATE TABLE IF NOT EXISTS OperationEntry (
    id INTEGER PRIMARY KEY, 
    company TEXT,   building TEXT
);
-- Create the logging table
CREATE TABLE IF NOT EXISTS OperationEntryChanges (
    oldid INTEGER, 
    newid INTEGER, 
    oldcompany TEXT, 
    newcompany TEXT, 
    oldbuilding TEXT, 
    newbuilding TEXT, 
    timestamp DEFAULT CURRENT_TIMESTAMP, -- assumes that you want some indications of when the update was made
    updatecounter DEFAULT 0 -- maybe over the top/not required may replace or compliment timestamp
    );
-- Create the logging trigger
CREATE TRIGGER OperationEntryTrigger
    AFTER UPDATE  ON OperationEntry
        BEGIN 
            INSERT INTO OperationEntryChanges 
                (oldid, newid, oldcompany, newcompany, oldbuilding, newbuilding, updatecounter) 
            VALUES
                (old.id, new.id, old.company, new.company, old.building, new.building, (SELECT count(*) + 1 FROM OperationEntryChanges)
                );
        END
;

-- Add some testing data
INSERT INTO OperationEntry (company, building) VALUES
        ('company1','Building1'),('company1','Building2'),('company1','Building3'),('company1','Building4'),
        ('company2','Building1'),('company2','Building2'),('company2','Building3'),
        ('company3','Building1'),('company3','Building2'),('company3','Building3'),('company3','Building4'),('company3','Building5')
;

-- Show the data prior to any updates
SELECT * FROM OperationEntry;
SELECT * FROM OperationEntryChanges;

-- Apply some updates
UPDATE OperationEntry SET company = company || 'A' WHERE Building = 'Building2';
UPDATE OperationEntry SET building = replace(building,'Building','Bldg') WHERE building = 'Building5';
UPDATE OperationEntry SET building = building||'X', company = company||'X' WHERE company = 'company1' AND building = 'Building3';

-- Show the data post updates
SELECT * FROM OperationEntry;
SELECT * FROM OperationEntryChanges;
-- Show the changes made
SELECT 
  datetime(timestamp),
    updatecounter,
    CASE 
      WHEN oldcompany <> newcompany AND oldbuilding <> newbuilding THEN 'Company changed from '|| oldcompany || ' to ' || newcompany || ', also Building changed from ' || oldbuilding || ' to ' || newbuilding
        WHEN oldcompany <> newcompany THEN 'Company changed from '|| oldcompany || ' to ' || newcompany 
      WHEN oldbuilding <> newbuilding THEN 'Building changed from ' || oldbuilding || ' to ' || newbuilding END AS changemade
FROM OperationEntryChanges
;