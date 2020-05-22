class B extends A {

    public void print() throws IOException {
        System.out.println("In Class B.");
        throw new IOException("Printed in B.");
    }

}