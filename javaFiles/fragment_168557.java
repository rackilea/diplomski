@Inject
public setDefaultRenderingEngine(
    final RendererRegistry rendererRegistry,
    final TemplateDefinitionAssignment templateDefinitionAssignment,
    final RenderableVariationResolver variationResolver,
    final Provider<RenderingContext> renderingContextProvider
) {
    renderingEngine = new DefaultRenderingEngine(rendererRegistry, templateDefinitionAssignment,
            variationResolver, renderingContextProvider);
}