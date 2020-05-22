Collections.sort(userMeters, new Comparator<UserMeter>() {
                @Override
                public int compare(UserMeter m1, UserMeter m2) {
                    if (mp.get(m1.getPriority()) == mp.get(m2.getPriority())) return 0;
                    if (mp.get(m1.getPriority()) > mp.get(m2.getPriority())) return 1;
                    return -1;
                }
            });