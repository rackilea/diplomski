Arrays.stream(new Student[]{sa, sb, sc})
    .filter(s -> {
        for(String className : s.classes) {
            if(className.equals("math")) return true;
        }
        return false;
    })