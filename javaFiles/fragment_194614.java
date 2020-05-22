for (Class someClass : someClassHashSet){
        Object value = null;
        try {
            value = someClass.getField("A_VARIABLE").get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("The value is: " + value);
}