public static void main(String[] args) throws Exception {
long init = System.currentTimeMillis();
int count = 0;
for (int i = 0; i < 1000000; ++i) {
    Field[] fields = User.class.getDeclaredFields();
    for (Field field : fields) {
        if (field.getName().equals("firstname")) {
            count++;
        }
    }
}
System.out.println(count);
System.out.println(System.currentTimeMillis() - init);
}