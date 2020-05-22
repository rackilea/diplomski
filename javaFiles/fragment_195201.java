select t.*
from (values ('02597'), ('69875')) v(submission_number) cross apply
     (select top (1) t.*
      from mytable t
      where t.submission_number = v.submission_number
      order by t.timestamp desc
     ) t;