public class Triangle {

    private Point pointA;

    @Autowired
    public Triangle(@Qualifier("pointA") Point pointA) {
        this.pointA = pointA;
    }

    ...
}