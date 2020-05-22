DELIMITER @@

CREATE FUNCTION getCustomerFullName(commaSeparatedString VARCHAR(256))
RETURNS INT
BEGIN
  DECLARE value1 INT DEFAULT 0;
  DECLARE value2 INT DEFAULT 0;
  DECLARE value3 INT DEFAULT 0;
  DECLARE value4 INT DEFAULT 0;
  DECLARE value5 INT DEFAULT 0;
  DECLARE value6 INT DEFAULT 0;
  DECLARE value7 INT DEFAULT 0;

  IF NOT commaSeparatedString IS NULL
    THEN
          SELECT LENGTH(commaSeparatedString) - LENGTH(REPLACE(commaSeparatedString, ',', '')) INTO @commaCount;

          IF  @commaCount = 0
            THEN
                 RETURN 0;  
          ELSE
            SET value1 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 1),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 0)) + 1), ',', '');
            SET value2 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 2),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 1)) + 1), ',', '');
            SET value3 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 3),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 2)) + 1), ',', '');
            SET value4 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 4),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 3)) + 1), ',', '');
            SET value5 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 5),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 4)) + 1), ',', '');
            SET value6 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 6),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 5)) + 1), ',', '');
            SET value7 = REPLACE(SUBSTRING(SUBSTRING_INDEX(commaSeparatedString, ',', 7),LENGTH(SUBSTRING_INDEX(commaSeparatedString, ',', 6)) + 1), ',', '');

        END IF;
  END IF; 

  CALL updateLastModifiedDate(value1, value2, value3, value4, value5, value6, value7);

  RETURN 1;
END;
@@

DELIMITER ;