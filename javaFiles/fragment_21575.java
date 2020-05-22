List<Object> objs = query.list();

for (int i=0; i<objs.size(); i++){
    Object row = objs.get(i);
    Object[] r = (Object[])row;
    System.out.println(r[0] + " " + r[1]);
}