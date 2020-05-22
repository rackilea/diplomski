class Getter_Setter {
        int id;
        String name;
        public List < Getter_Setter > buckets;
        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setGetter_Setter(List < Getter_Setter > buck) {
            this.buckets = buck;
        }
        @Override
        public String toString() {
            return "Getter_Setter [id=" + id + ", name=" + name + ", buckets="
                    + buckets + "]";
        }