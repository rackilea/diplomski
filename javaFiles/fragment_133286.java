boolean equals = true;
Field[] fields = a.getClass().getDeclaredFields();
for (Field f: fields){
    f.setAccessible(true);
        try {
            if (!f.get(a).equals(f.get(b))){
                System.out.println(f.getName() + ": " + f.get(a) + "!="+ f.get(b));
                equals = false;
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
}
System.out.println("equals?: " + equals);