CREATE PROCEDURE SP_GETNEXTSEQUENCE(OUT pno_new_id INTEGER, IN pni_seq_id INTEGER)  
    MODIFIES SQL DATA
    BEGIN ATOMIC    
        UPDATE SEQUENCE_GENERATOR SET seq_value=seq_value+1 where seq_id=pni_seq_id;
        SET pno_new_id = (select seq_value from SEQUENCE_GENERATOR where seq_id=pni_seq_id);     
    END
 .;