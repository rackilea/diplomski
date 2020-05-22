for (Method method : methods) {
        if (method.getAnnotations().length == 0) {
            System.out.println("Not present " + method.getName() + " isBridge? " + method.isBridge());
        } else {
            System.out.println("Present :" + method.getName() + " isBridge? " + method.isBridge());
        }
    }