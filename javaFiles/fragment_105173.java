Select e.*
FROM (Select e.*, rownum as row_id
      from (Select *
            FROM emp
            ORDER BY ename
           ) e
     ) e
Where row_id >= ((?-1)*?)+1 and row_id <= (?*?);