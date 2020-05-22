ArrayList<Integer> list = new ArrayList<Integer>();
Field[] fields = R.raw.class.getFields();
for(Field f : fields)
try {
        list.add(f.getInt(null));
    } catch (IllegalArgumentException e) {
    } catch (IllegalAccessException e) { }