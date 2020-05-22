for (int i = 0; i < data.size(); i++) {
    final String item = "Item "+i ;
    Domain d = data.get(i);
    d.getCompleted().addListener((obs, wasCompleted, isNowCompleted) -> {
        System.out.println("Completed state for "+item+" changed from "+wasCompleted+" to "+isNowCompleted);
    });
}