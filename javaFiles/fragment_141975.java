ArrayList<ACAdata> list = new ArrayList<>();
        Collections.sort(list);
        for (Iterator<ACAdata> iterator = list.iterator(); iterator.hasNext();) {
            ACAdata next = iterator.next();
            System.out.println(next.toString());
        }