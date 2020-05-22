public static void main(String[] args) {
        String in = "<p>Now a days, regenerative medicine(1) in stem cell(3) filed widely <label>attractive(10) by</label> attractive by scientists(4).</p>".replaceAll("<label>.*</label>", "");;
        //String inin = in.replaceAll("<label>.*</label>", "");
        //System.out.println(inin);
        Pattern p = Pattern.compile("\\((.*?)\\)");
        Matcher m = p.matcher(in);

        while(m.find()) {
            System.out.println("(" + m.group(1) + ")");
        }
    }