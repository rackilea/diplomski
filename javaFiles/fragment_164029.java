Comparator<Map.Entry<Point, Integer>> lexicoComparator = (e1, e2) -> {
            Point p1 = e1.getKey();
            Point p2 = e2.getKey();
            if (p1.x == p2.x){
                if (p1.y > p2.y)
                    return 1;
                if (p1.y == p2.y)
                    return 0;
                return -1;
            }
            if (p1.x > p2.x)
                return 1;
            return -1;
        };