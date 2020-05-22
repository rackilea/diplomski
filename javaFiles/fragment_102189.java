EventHandlerInterface h;
// eventMap contains a mapping of event codes to
// implementations of EventHandlerInterface
h = eventMap.get(event.getCode());
if(h != null)
{
    h.handle(event);
}