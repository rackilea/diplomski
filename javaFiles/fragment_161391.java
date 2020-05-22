0 / pageSize = 0 -> list.subList(0, min(0 + pageSize, 10)) = list.subList(0, 3);
3 / pageSize = 1 -> list.subList(3, min(3 + pageSize, 10)) = list.subList(3, 6);
6 / pageSize = 2 -> list.subList(6, min(6 + pageSize, 10)) = list.subList(6, 9);
9 / pageSize = 3 -> list.subList(9, min(9 + pageSize, 10))  = list.subList(6, 10);
                                      ^
                                      |
                        this is the edge-case for the last sublist to
                        not be out of bounds