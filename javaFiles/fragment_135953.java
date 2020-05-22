public static void main(String[] args) {
        String json = "YOUR JSON STRING"
        Gson gson = new Gson();
        DataWrap[] data = gson.fromJson(json, DataWrap[].class);
        System.out.println(data[0].getDRIVER().getAge());

    }


    public static class DataWrap {

        private Driver DRIVER;

        public Driver getDRIVER() {
            return DRIVER;
        }

        public void setDRIVER(Driver DRIVER) {
            this.DRIVER = DRIVER;
        }
    }

    public static class Driver {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }