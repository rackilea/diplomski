Pass 1:
index = 0
i = 0
r[index] = new ... which is fine as index is 0
index += 2 so now index is 2
Pass 2:
i = 1
r[index] = new ... since you defined r as Exam[] r = new Exam[exams.length]; which means you could just access r[0] and r[1] and now you are trying to set r[2] which is not valid.