if (i < itemList_dump.size()) {

    MyBitamp Data = itemList_dump.get(original_position_val);
            // setting Values according to our algorithm
                    Data.setItemCurPos(original_position_val);
                    Data.setItemPosition(current_positon_val);
                    Data.setrotation(rotataion_val);

                }
            }
            Collections.sort(itemList_dump, new Comparator<MyBitamp>() {

                @Override
                public int compare(MyBitamp o1, MyBitamp o2) {
                    if (o1.getItemPosition() > o2.getItemPosition()) {
                        return 1;
                    } else if (o1.getItemPosition() < o2.getItemPosition()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });