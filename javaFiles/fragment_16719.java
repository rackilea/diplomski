class Item {
        private String name;
        private String abbreviation;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        @Override
        public String toString() {
            return new StringBuilder().append("[name=").append(name).append(", abbreviation=").append(abbreviation).append("]")
                    .toString();
        }
    }