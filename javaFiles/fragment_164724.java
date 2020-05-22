public static void main(String[] args) {
        List asList = Arrays.asList("banner", "carousel", "banner", "carousel", "banner");
        for(int i=0;i<asList.size();i++) {
            System.out.println(asList.get(i)+" : " + Collections.frequency(asList.subList(0,i), asList.get(i)));
        }
    }