Iterator<studentInfo> disp = stud.iterator();
        while(disp.hasNext()){
            studentInfo info = disp.next();
            System.out.println(info.getFname());
            System.out.println(info.getLname());
            System.out.println(info.getInstName());
            System.out.println(info.getCourseNo());
            System.out.println("Student Displayed\n");
        }