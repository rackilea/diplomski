LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("This");
        linkedList.add("is");
        linkedList.add("an");
        linkedList.add("test");

        LinkedList<String> temp = new LinkedList<String>();

        for (Iterator<String> iterator = linkedList.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();

            if(string.equals("an")) {
                iterator.remove();

                temp.add("a");
            }
        }

        linkedList.addAll(temp);