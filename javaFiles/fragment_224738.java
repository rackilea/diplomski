histogram.computeIfAbsent(result, AtomicLong::new);
histogram.get(result).incrementAndGet();

// or
if (histogram.putIfAbsent(result, new AtomicLong(1)) == null)
   histogram.get(result).incrementAndGet();

// or even
histogram.compute(result, ($, current) -> {
   if (current == null) return new AtomicLong(1);
   current.incrementAndGet();
   return current;
});