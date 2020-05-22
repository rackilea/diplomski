CREATE INDEX lightbulb_by_status ON lightbulbstatus (status);

SELECT * FROM lightbulbstatus 
  WHERE status = 1 
    AND carmake = 'chevy' 
    AND carmodel = 'nova'
    AND carvin = cfe638e9-5cd9-43c2-b5f4-4cc9a0e6b0ff;