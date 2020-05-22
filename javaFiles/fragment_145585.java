final ByteBuffer view = base.slice();
for (int start = base.position(), end = base.limit(), stride = 1000000;
     start != end;
     start = view.limit())
  consume(view.position(start)
              .limit(start + Math.min(end - start, stride)));