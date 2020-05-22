Collections.sort(mediaStatsDetailsArrayList, new Comparator <HashMap<String, String>>() {
            @Override
            public int compare(HashMap h1, HashMap h2) {
                int likes1 = Integer.parseInt((String) h1.get("noOfLikes"));
                int sum1 = (Integer.parseInt((String) h1.get("noOfLikes")) + Integer.parseInt((String) h1.get("noOfComments")));
                h1.put("likes", likes1);
                h1.put("sum", sum1);
                int likes2 = Integer.parseInt((String) h2.get("noOfLikes"));
                int sum2 = (Integer.parseInt((String) h2.get("noOfLikes")) + Integer.parseInt((String) h2.get("noOfComments")));
                h2.put("likes", likes2);
                h2.put("sum", sum2);
                if (sum1 == sum2)
                    return ((Integer) h1.get("likes")).compareTo((Integer) h2.get("likes"));
                return ((Integer) h1.get("sum")).compareTo((Integer) h2.get("sum"));
            }
        });