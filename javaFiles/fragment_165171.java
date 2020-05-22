public void testNewClass() 
            throws Throwable {
        CtClass ctclass =  ClassPool.getDefault().get("bin.objects.base.NewClass");
        Class newClass = ctclass.toClass(this.getClass().getClassLoader(), 
            this.getClass().getProtectionDomain());
        Object objNewClass  = newClass.newInstance();

        System.out.println("Accessing the field 'public int quantity'..."); 
        Field q = newClass.getDeclaredField("quantity");        
        int quantity = (int) q.get(objNewClass);
        System.out.println("quantity = " + quantity);

        System.out.println("\nAccessing the field 'private float weight' " +
            "through the method 'public float getWeight()'...");
        Method m = newClass.getDeclaredMethod("getWeight", null);
        float weight = (float) m.invoke(objNewClass, null);
        System.out.println("weight = " + weight);

        System.out.println("\nAccessing the method 'public float totalWeight()'...");
        m = newClass.getDeclaredMethod("totalWeight", null);
        float totalWeight = (float) m.invoke(objNewClass, null);        
        System.out.println("totalWeight = " + totalWeight);
    }