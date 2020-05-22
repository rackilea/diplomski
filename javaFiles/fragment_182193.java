@Service
@Transactional
public class CanvasServiceImpl implements CanvasService {

    private final CanvasDAO canvasDAO;

    public CanvasServiceImpl(CanvasDAO canvasDAO) {
        this.canvasDAO=canvasDAO;
    }

    //methods
}