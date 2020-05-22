// repeat forever
for (;;)
{
  // this will block until there's something inside the buffer
  WatchKey key = service.take();

  // 1 watchkey can contain multiple events, you need to iterate these.
  for (WatchEvent<?> event : key.pollEvents())
  {
    //todo: handle events
  }
}