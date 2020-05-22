for (ArrayList<PhoneBookEntry> x : buckets) {
                for (int i = 0; i < x.size(); i++) {
                    list.add(x.get(i).getN());
                }
                Collections.sort(list);
                ListIterator<String> iterator = list.listIterator(); // Iterator created here
                for (int b = 0; b < x.size(); b++) {
                    temp = iterator.next(); //error line
                    x.get(b).setN(temp);
                    x.get(b).setNr(internalLookUp(temp));
                }