JavaRDD<Record> data = sc.parallelize(
                Lists.newArrayList(
                        new Record(33, "Jack", "USA"),
                        new Record(24, "Sam", "USA"),
                        new Record(24, "Dan", "USA"),
                        new Record(31, "Jack", "USA")));
        JavaRDD<Record> sorted 
            = data.sortBy(rec -> rec, true, data.partitions().size());
        System.out.println(sorted.collect());

    //define bean
    class Record implements Serializable, Comparable<Record> {
        private int age;
        private String name;
        private String country;

        public Record(int age, String name, String country) {
            this.age = age;
            this.name = name;
            this.country = country;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public int compareTo(Record o) {
            int compAge = Integer.compare(this.age, o.age);
            if (compAge != 0) return compAge;
            else return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("age", age)
                    .append("name", name)
                    .append("country", country)
                    .toString();
        }
    }