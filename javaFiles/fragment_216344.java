SELECT p.idPath, p.token, p.isTV, r.rel
FROM path p LEFT OUTER JOIN
     relation r
     ON p.idTokenN = r.idTokenN JOIN
     (select idPath, max(case when p.isTV = 'true' then 1 else 0 end) as HasTv,
             (case when COUNT(*) between 2 and 3 then 1 else 0 end) as Has2_3
      from path p
      group by idpath
     ) pf
     on p.idpath = pf.idpath and
        pf.HasTv = 1 and pf.Has2_3  = 1;