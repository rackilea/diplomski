public final class GameServices {

    public final InputService inputService;
    public final RenderingService renderingService;
    public final GameStateService gameStateService;

    public GameServices(final InputService inputService, 
        final RenderingService renderingService, 
        final GameStateService gameStateService) {

        this.inputService = inputService;
        this.renderingService = renderingService;
        this.gameStateService = gameStateService;
    }
}