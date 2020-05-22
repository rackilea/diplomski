public static void main(String args[]) {
    Date initialDate = new Date();
    getXmlValue();// or getDBValue();
    Date finalDate = new Date();
    System.out.println("Load XML took " + (initialDate.getTime()-finalDate.getTime()) + "ms");
}