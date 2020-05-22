button bt=new button();
Field field = bt.getClass().getDeclaredField("anc");
field.setAccessible(true);

//This sets the field value for the instance "bt"
field.set(bt, new testPrivate());