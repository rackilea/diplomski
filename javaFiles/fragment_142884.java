select 
    count(distinct t.activity_task_id) No_of_task,
    count(distinct a.milestone_activity_id) no_activity,
    m.milestone_description milestone_name
from milestone m
inner join activity a
    on m.project_milestone_id = a.project_milestone_id
inner join task t
    on a.milestone_activity_id = t.milestone_activity_id
where t.status != 4
and t.task_end_date < curdate()
group by m.project_milestone_id,
    m.milestone_description;