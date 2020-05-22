synchronized static void register(ConfigurationContext context)
{
    Phase hookPhase = null;
    for (Phase phase: context.getAxisConfiguration().getOutFaultFlowPhases())
    {
        for (Handler handler : phase.getHandlers())
        {
            if (WsExceptionFilter.isMe(handler))
            {
                return;
            }
        }

        if (phase.getPhaseName().equals("MessageOut"))
        {
            hookPhase = phase;
        }
    }
    if (hookPhase == null)
    {
        throw new UnsupportedOperationException("Missing hook phase.");
    }

    hookPhase.addHandler(new WsExceptionFilter());
}