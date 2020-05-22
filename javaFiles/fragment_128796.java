protected void addElements(GameElement... elements){
    // either:
    this.elements.addAll(Arrays.asList(elements));

    // or as @VGR commented:
    Collections.addAll(this.elements, elements)
}