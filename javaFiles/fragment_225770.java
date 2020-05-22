Arrays.sort(data, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                String employee1 = (String) o1[0];
                String employee2 = (String) o2[0];
                String chief1 = (String) o1[1];
                String chief2 = (String) o2[1];

                if(chief1.equals(chief2))
                    // same chief, sort by empolyee keeping Chief at top
                    if(employee1.equals(chief1))
                        return -1;
                    else if(employee2.equals(chief2))
                        return 1;
                    else
                        return employee1.compareTo(employee2);
                else
                    // if chiefs aren't equals, sort relying on them
                    return chief1.compareTo(chief2);
            }
        });