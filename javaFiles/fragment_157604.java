public int compareTo(Movie m) {
            if (this.likes == m.likes) {
                //DefaultComparator cmp = new DefaultComparator();
                return this.compareTo(m);
            } else if (this.likes > m.likes) {
                return 1;
            } else {
                return -1;
            }

        }