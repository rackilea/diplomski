Map<String, String> original = new HashMap<>();
original.put("hello", "world");

// Obviously false, we just put something into it.
assertFalse(original.isEmpty());

Map<String, String> unmodifiable = Collections.unmodifiableMap(original);
// We didn't modify the original, so we don't expect this to have changed.
assertFalse(original.isEmpty());
// We expect this to be the same as for the original.
assertFalse(unmodifiable.isEmpty());

try {
  unmodifiable.clear();
  fail("Expected this to fail, as it's unmodifiable");
} catch (UnsupportedOperationException expected) {}

// Yep, still the same contents.
assertFalse(original.isEmpty());
assertFalse(unmodifiable.isEmpty());

// But here's where it gets sticky - no exception is thrown.
original.clear();
// Yep, we expect this...
assertTrue(original.isEmpty());

// But - uh-oh - the unmodifiable map has changed!
assertTrue(unmodifiable.isEmpty());