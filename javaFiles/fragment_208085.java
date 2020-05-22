Consumer<List<String>> handleTexture = new Consumer<List<String>>() { 
    @Override
    public void accept(List<String> args) {
        textures.add(parseTexture(args));
    }
}