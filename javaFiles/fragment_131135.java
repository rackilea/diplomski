while (true) {
        System.out.println("Insert information: ");
        newInfo = input.nextLine();
        if (newInfo.equals("end")){
            break;
        }
        Test.setTest(newInfo);
        queue.offer(Test.getTest());
    }