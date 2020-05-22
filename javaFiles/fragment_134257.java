String s = "your string";
        StringBuilder sb = new StringBuilder();
        String[] sp = s.split(" ");
        for(String a : sp) {
            if(!a.trim().equals(""))
            sb.append(a+" ");
        }
            System.out.println(sb.toString().trim());