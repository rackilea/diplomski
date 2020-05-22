public void work(T t){
    for(Field f : t.getClass().getDeclaredFields()){
        try {
            f.setAccessible(true);

            String name = f.getName();
            Object value = f.get(object);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}