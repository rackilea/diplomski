List<JLabel> jlabelList = new ArrayList<JLabel>();
        JLabel buf = null;
        for (int i = 0; i < 5; i++) {
            buf = new JLabel("label_" + i);
            buf.setName(Integer.toString(i));
            jlabelList.add(buf);
        }

        //later iterate or loop to find it
        JLabel c = null;
        for (JLabel jlabelList1 : jlabelList) {
            if (jlabelList1.getName().equalsIgnoreCase(Integer.toString(1))) {
                c = jlabelList1;
                System.out.println("JlabelFound -->" + c.getName() + c.getText());
            }
        }