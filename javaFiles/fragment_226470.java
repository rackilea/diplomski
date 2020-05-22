public class Smiley extends JPanel {
  private Color outline;
  private Color face;
  private Color smile;
  private Color eyes;

  public Smiley() {
     this(new Random());
  }

  public Smiley(Random rand) {
    outline = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    face = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    smile = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    eyes = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
  }

 public Smiley(Color outline, Color face, Color smile, Color eyes) {
    this.outline = Objects.requireNonNull(outline);
    this.face = Objects.requireNonNull(face);
    this.smile = Objects.requireNonNull(smile);
    this.eyes = Objects.requireNonNull(eyes);
  }


  ...
}