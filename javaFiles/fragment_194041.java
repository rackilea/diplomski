SELECT POLICY_NO,
       MAX(CASE WHEN SEX= 0 THEN FIRST_NAME END) FIRST_NAME,
       MAX(CASE WHEN SEX= 0 THEN LAST_NAME END) LAST_NAME,
       MAX(CASE WHEN SEX= 0 THEN DOB END) DOB,
       MAX(CASE WHEN SEX= 0 THEN SEX END) SEX,
       MAX(CASE WHEN SEX= 1 THEN FIRST_NAME END) FIRST_NAME2,
       MAX(CASE WHEN SEX= 1 THEN LAST_NAME END) LAST_NAME2,
       MAX(CASE WHEN SEX= 1 THEN DOB END) DOB2,
       MAX(CASE WHEN SEX= 1 THEN SEX END) SEX2
FROM T
GROUP BY POLICY_NO;

| POLICY_NO | FIRST_NAME | LAST_NAME | DOB        | SEX | FIRST_NAME2 | LAST_NAME2 | DOB2       | SEX2 |
| --------- | ---------- | --------- | ---------- | --- | ----------- | ---------- | ---------- | ---- |
| 1234      | JOHN       | HILL      | 01/01/1978 | 0   | JILL        | HILL       | 10/10/1980 | 1    |
| 5678      | JAMES      | PIKE      | 05/05/1950 | 0   | JOAN        | MAY        | 04/04/1955 | 1    |