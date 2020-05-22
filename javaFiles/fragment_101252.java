FileHandle f = Gdx.files.internal("test/test.txt");

Scanner scanner = new Scanner(f.read());

while(scanner.hasNext()){
    System.out.println(scanner.nextLine());
}