private class Foo implements PdxSerializable {
        private String bar;
        private Integer baz;

        public Foo(final String bar, final Integer baz) {

            this.bar = bar;
            this.baz = baz;
        }

        public String getBar() {
            return bar;
        }

        public Integer getBaz() {
            return baz;
        }
        public void toData(PdxWriter out) {
         //your pdx stuff
        }

        public void fromData(PdxReader in) {
          //your pdx work
        }
    }

//and a custom reader and writer 
     private void writeCustom(final Foo foo, final Path path) throws IOException {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {
            objectOutputStream.writeChars(foo.getBar());
            objectOutputStream.writeInt(foo.getBaz());
        }
    }

    private Foo readCustom(final Path path) throws IOException {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            String bar = objectInputStream.readUTF();
            Integer baz = objectInputStream.readInt();
            return new Foo(bar, baz);
        }
    }