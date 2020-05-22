select s.*
from student s
join (
    select student_id
    from student_attribute
    group by student_id
    having count(case 
                when attribute_name = 'school'
                    and attribute_value = 'UofJ'
                    then 1
                end) > 0
        and count(case 
                when attribute_name = 'company'
                    and attribute_value = 'J Limited'
                    then 1
                end) > 0
    ) a on s.student_id = a.student_id;