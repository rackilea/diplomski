while(itr.hasNext()){    
        TestWopk test = (TestWopk) itr.next();
        System.out.print("EmpName: " + test.getId().getId());
        System.out.print(" EmpSal: " + test.getId().getName());
        System.out.print(" EmpSal: " + test.getId().getAge());
        System.out.println();
    }