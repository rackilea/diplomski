SELECT
    teacher_id,
    GROUP_CONCAT(student_id SEPARATOR '|') students
FROM yourTable
GROUP BY
    teacher_id;