LinkedList<String> ll = new LinkedList<String>();
    ll.add("[q0/q1]");

    // since you tagged it [regex] :-)
    Pattern p = Pattern.compile("\\[(.*?)/(.*?)\\]");

    LinkedList<String> ll2 = new LinkedList<String>();
    for (String pair : ll) {
        Matcher m = p.matcher(pair);
        if (m.matches()) {
            ll2.add(m.group(1));
            ll2.add(m.group(2));
        }
    }

    System.out.println(ll2);  // prints [q0, q1]