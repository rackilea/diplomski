final Something something = optionalSomething.get();
if (something == null) {
  // no such Something, but an expected case
} else {
  something.doWhatIWant(NOW);
}