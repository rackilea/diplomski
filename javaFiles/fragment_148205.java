Class classofStudent = Student.class;
    Method[] methodsOfStudent = classofStudent.getDeclaredMethods();

    for (Method method : methodsOfStudent) {

        if (isGetType(method)) {
            if (method.getReturnType() == String.class) {
                System.out.println(method.getName());
            } else {

                Class innerObjectClass = method.getReturnType();
                Method[] methodsOfinnerObject = innerObjectClass.getDeclaredMethods();
                for (Method methodofInnerClass : methodsOfinnerObject) {
                    if (isGetType(method)) {
                        System.out.println(methodofInnerClass.getName());
                    }
                }
            }
        }
    }