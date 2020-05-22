CREATE PROCEDURE [dbo].[GetPhonetic] 
    @letters dbo.LetterListTableType READONLY
AS
BEGIN
    SET NOCOUNT ON;
    SELECT l.seq, l.letter, p.word 
        FROM phonetic p INNER JOIN @letters l on p.letter = l.letter
        ORDER BY l.seq;
END