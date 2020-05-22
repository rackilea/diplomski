SELECT
  a.id,
  b.status
FROM
  atable a
  JOIN btable b ON a.btable_id = b.id
  JOIN btable b2 ON a.btable_id = b2.id
WHERE (b.status = 'INITIAL' AND a.main_atable_id IS NULL)
OR (b2.status = 'INITIAL' AND b2.main_atable_id = a.id);