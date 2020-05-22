while (it.hasNext()) {
            Person p = it.next();
            if (p.getLast().toLowerCase().equals(last)) {
                System.out.println(p);
            }
        }