mtutors.forEach((tutorName, subject) -> {
        mstudents.forEach((studentName, subjects) -> {
            if (subjects.contains(subject)) {
                System.out.println(tutorName + ":" + studentName + ":" + subject);
            }
        });
    });