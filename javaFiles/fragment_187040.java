IEclipseContext tempContext = EclipseContextFactory.create();

tempContext.set(Composite.class, composite);

// ... more parameters

Two two = ContextInjectionFactory.make(Two.class, context, tempContext);