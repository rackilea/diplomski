CREATE TABLE categories ( id, name, parent_id ) AS
SELECT  1, 'Restauracion', NULL FROM DUAL UNION ALL
SELECT  2, 'Desayuno',        1 FROM DUAL UNION ALL
SELECT  3, 'Calidad',         2 FROM DUAL UNION ALL
SELECT  4, 'Organizacion',    2 FROM DUAL UNION ALL
SELECT  5, 'Variedad',        2 FROM DUAL UNION ALL
SELECT  6, 'Personal',     NULL FROM DUAL UNION ALL
SELECT  7, 'Pisos',           6 FROM DUAL UNION ALL
SELECT  8, 'Falta de Personal', 7 FROM DUAL UNION ALL
SELECT  9, 'Trato',           7 FROM DUAL UNION ALL
SELECT 10, 'Informacion',     7 FROM DUAL UNION ALL
SELECT 11, 'Idiomas',         7 FROM DUAL UNION ALL
SELECT 12, 'Otros',           7 FROM DUAL;