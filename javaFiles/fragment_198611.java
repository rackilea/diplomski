if (bfname) {
            emp = new Employee();
            fname = new String(ch, start, length);
            System.out.println("First Name : " + fname);
            emp.setFirstName(fname);
            testList.add(fname);
            bfname = false;
        }