SELECT classID,
       ARRAY_TO_STRING(ARRAY_AGG(firstName || secondName || fathersName), ', ')
FROM Student, Class
WHERE studentGender = Male
GROUP BY classID
ORDER BY studentID;