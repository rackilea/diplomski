SELECT classID,
       STRING_AGG(firstName || secondName || fathersName, ', ')
FROM Student, Class
WHERE studentGender = Male
GROUP BY classID
ORDER BY studentID;