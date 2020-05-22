List<StructorRecords> tmpList = new ArrayList<StructorRecords> tmpList;
while (itr.hasNext()) {
        StructorRecords SR = (StructorRecords) itr.next();
        if (SR.id.equals(data.id)) {
            data.count = SR.count + 1;
            G.savelike.set(i, data);
        } else {
            // here put to temp list
            tmpList.add(data);
        }
        i++;
    }
    // add all new elements
    G.savelike.addAll(tmpList);