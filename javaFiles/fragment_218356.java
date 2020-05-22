public Sphere() {
        this.x = (int) (Math.random() * 100); // cast the result to int not the random
        this.y = (int) (Math.random() * 100);
        this.radius = (int) (Math.random() * 20);
        this.color = new Color((int) ((Math.random() * 255)), (int) (Math.random() * 255), (int) (Math.random() * 255));
}