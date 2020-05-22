// servlet 1:
Person p = new Person("Keith", "Richards");
context.setAttribute('key', p); // share p
p.setName("Ron", "Wood"); // modification AFTER sharing

// servlet 2 (some time LATER):
Person p = context.getAttribute();
// now, p is guaranteed to be non-null,
// but if class Person is not thread-safe by itself, it may be any of
// - "Keith Richards"
// - "Keith Wood"
// - "Ron Richards"
// - "Ron Wood"
// (depending on the implementation of setName, it may be even worse!)