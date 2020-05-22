ServiceObject serviceObject =
                    new LoggingDecorator(
                            new SynchronizedDecorator(
                                    new ServiceObjectImpl()
                            )
                    );