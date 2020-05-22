String[] arr1 = "aaa bbb ccc ddd".split(" ");
        String[] arr2 = "111 222 333 444".split(" ");

        StringBuilder text3 = new StringBuilder("");

        for(int i=0;i<arr1.length; i++) {
            text3.append(arr1[i]).append(arr2[i]).append("\n");
        }


        TextArea textArea3 = new TextArea();
        textArea3.setText(text3.toString());