public static void sortFactoryMethods(Method[] factoryMethods) {
    Arrays.sort(factoryMethods, new Comparator<Method>() {
        @Override
        public int compare(Method fm1, Method fm2) {
            boolean p1 = Modifier.isPublic(fm1.getModifiers());
            boolean p2 = Modifier.isPublic(fm2.getModifiers());
            if (p1 != p2) {
                return (p1 ? -1 : 1);
            }
            int c1pl = fm1.getParameterTypes().length;
            int c2pl = fm2.getParameterTypes().length;
            return (new Integer(c1pl)).compareTo(c2pl) * -1;
        }
    });
}