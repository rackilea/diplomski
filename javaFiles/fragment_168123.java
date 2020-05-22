public static void main(String[] args) {
        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film(100));
        films.add(new Film(400));
        films.add(new Film(200));
        films.add(new Film(300));
        System.out.println(Collections.max(films).getFinalScore());//prints 400     
    }