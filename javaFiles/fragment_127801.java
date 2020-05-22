select
   students.student,
   students.major,
   students.trans,
   prev_row.major prev_major,
   prev_row.trans prev_trans
 from
   students
   join students prev_row
     on (students.student = prev_row.student
       and students.trans = prev_row.trans + 1
       and students.major != prev_row.major)
 where
   exists (select 'x'
             from students prev_row
            where students.student = prev_row.student
                 and students.trans > prev_row.trans + 1
                and students.major = prev_row.major);